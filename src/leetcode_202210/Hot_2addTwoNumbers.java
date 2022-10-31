package leetcode_202210;

import leetcode_202206.jzofferII.Solution_24;

/**
 * @description: https://leetcode.cn/problems/add-two-numbers/
 * @author: fanghao
 * @create: 2022/10/29
 **/
public class Hot_2addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while(p1 != null && p2 != null){
            int curSum = p1.val + p2.val + carry;
            carry = 0;
            if (curSum > 9){

                curSum = curSum % 10;
                carry++;
            }
            ListNode node = new ListNode(curSum);
            p.next = node;
            p = p.next;

            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null){
            int c = p1.val + carry;
            carry = 0;
            if (c > 9){
                c = c % 10;
                carry ++;
            }
            ListNode node = new ListNode(c);
            p.next = node;
            p = p.next;
            p1 = p1.next;

        }
        while(p2 != null){
            int c = p2.val + carry;
            carry = 0;
            if (c > 9){
                c = c % 10;
                carry ++;
            }
            ListNode node = new ListNode(c);
            p.next = node;
            p = p.next;
            p2 = p2.next;
        }
        if (carry != 0){
            ListNode node = new ListNode(carry);
            p.next = node;
        }
        return dummy.next;
    }
    private static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

        ListNode next1 = new ListNode(9);
        ListNode next2 = new ListNode(9);
        ListNode next3 = new ListNode(9);
        ListNode l1 = new ListNode(9);
        l1.next = next1;next1.next = next2;next2.next = next3;

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = n1;n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;
        addTwoNumbers(l1, l2);
    }
}
