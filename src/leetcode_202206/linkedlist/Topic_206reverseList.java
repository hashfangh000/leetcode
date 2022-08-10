package leetcode_202206.linkedlist;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * 反转链表
 * @author fanghao on 2022/6/6
 */
public class Topic_206reverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        /*if (head == null){
            return null;
        }
        ListNode newHead = null, p = head;
        while (p != null){
            ListNode next = p.next;
            p.next = newHead;
            newHead = p;
            p = next;
        }
        return newHead;
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}