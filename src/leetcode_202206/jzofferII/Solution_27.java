package leetcode_202206.jzofferII;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/aMhZSa/
 * @author: fanghao
 * @create: 2022-06-23 20:44
 * 判断链表是否为回文链表
 **/

public class Solution_27 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head, slow = head;
        ListNode p = head, newHead = null;
        //将链表的前半部分反转 为newHead
        while(fast != null && fast.next != null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
            p.next = newHead;
            newHead = p;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(newHead != null && slow != null){
            if(newHead.val != slow.val){
                return false;
            }
            newHead = newHead.next;
            slow = slow.next;
        }
        return true;
    }
}
