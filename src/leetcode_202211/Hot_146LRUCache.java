package leetcode_202211;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode.cn/problems/lru-cache/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/15
 *
 * LRU ---> 双向链表
 *  双向链表的头部是最近使用的，从head -> tail 使用频率依次递减，最久未使用的，是tail节点
 *
 **/
public class Hot_146LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail; //head tail 节点不存数据

    public Hot_146LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    // 如果关键字key 存在于缓存中，返回key对应的value，否则 返回-1
    // get(key) 表示key被使用过，需要将其移动到头部
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
    // 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){      //不存在 插入
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity){       //插入导致 数量超过capacity
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{      //存在，变更value, 使用过，移动到头
            node.value = value;
            moveToHead(node);
        }
    }
    //删除最后一个节点,并返回node,将cache中的也删除
    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
