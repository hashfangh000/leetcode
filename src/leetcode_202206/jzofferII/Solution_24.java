package leetcode_202206.jzofferII;

import leetcode_202206.linkedlist.Topic_1290getDecimalValue;

import java.util.List;

/**
 * @program: leetcode_202206.jzofferII
 * @description: https://leetcode.cn/problems/UHnkqh/
 * @author: fanghao
 * @create: 2022/6/8 21:46
 */
public class Solution_24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        ListNode newhead = null, pre = head;
//        while (pre != null){
//            ListNode next = pre.next;
//            pre.next = newhead;
//            newhead = pre;
//            pre = next;
//        }
//        return newhead;
        if (head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        Solution_24 solution = new Solution_24();
        ListNode head = new  ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        head.next = next1;next1.next = next2; next2.next = next3;
        solution.reverseList(head);
    }
}