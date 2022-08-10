package leetcode_202206.linkedlist;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 判断链表是否为 回文链表
 * @author fanghao on 2022/6/6
 */
public class Topic_234isPalindrome {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode fast = head, slow = head;
        ListNode p = head, newHead = null;
        while (fast != null && fast.next != null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
            p.next = newHead;
            newHead = p;
        }
        if (fast != null){
            slow = slow.next;
        }
        while (p != null && slow != null){
            if (p.val != slow.val){
                return false;
            }
            p = p.next;
            slow = slow.next;
        }
        return true;
    }
}