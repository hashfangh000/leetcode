package leetcode_202206.linkedlist;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * 删除单链表中某个特定结点 不能访问链表头结点head,只能访问 要被删除的结点
 * 被删除的结点不是末尾结点
 * @author fanghao on 2022/6/6
 */
public class Topic_237deleteNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
//        ListNode s = node.next;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}