package leetcode_202210;


/**
 * @description: https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author: fanghao
 * @create: 2022/11/1
 *
 * 交换链表中相邻的节点
 * head = [1,2,3,4]
 * 输出：[2,1,4,3]
 **/
public class Hot_24swapPairs {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
            //迭代
//        ListNode dummy = new ListNode(-1, head);
//        ListNode p = dummy;
//        while (p.next != null && p.next.next != null){
//            ListNode node1 = p.next;                //  待交换的两个节点
//            ListNode node2 = p.next;
//
//            p.next = node2;
//            node1.next = node2.next;
//            node2.next = node1;
//            p = node1;
//        }
//        return dummy.next;
        //递归
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
