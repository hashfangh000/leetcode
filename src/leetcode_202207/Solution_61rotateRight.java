package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/rotate-list/
 * @author: fanghao
 * @create: 2022-07-19 21:23
 **/

public class Solution_61rotateRight {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode p = head;
        int len = 0;
        while (p != null){
            p = p.next;
            len++;
        }
        ListNode fast = head, slow = head;
        int faststep = k % len;
        while (faststep > 0){
            fast = fast.next;
            faststep--;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
