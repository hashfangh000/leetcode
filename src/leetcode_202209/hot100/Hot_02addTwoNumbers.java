package leetcode_202209.hot100;

import java.util.List;

/**
 * @description: https://leetcode.cn/problems/add-two-numbers/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/8/30
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 *  2 -> 4 -> 3
 *  5 -> 6 -> 4
 *  结果 7 -> 0 -> 8
 * 注意 数是倒着看的
 *
 * 考虑 ： 将 l1, l2 的值 加到 新的链表上
 * 进位 carry = 0
 * p1, p2 分别为两个链表的遍历节点，p1.next != null && p2.next != null
 * cur = p1.val + p2.val
 * carry = cur / 10
 * cur = cur % 10
 * p1.val = cur
 * p1 = p2.next, p2 = p2.next
 * 进位多一位的情况：   p1.next == null || p2 == null,
 *  ListNode node = new ListNode(carry)
 *  p1.
 **/
public class Hot_02addTwoNumbers {
    /**
     * Definition for singly-linked list.*/
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        while(p1 != null && p2 != null){
            int cur = p1.val + p2.val + carry;
            ListNode node = new ListNode(cur % 10);
            p.next = node;
            p = node;
            carry = cur / 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null){
            int cur = p1.val + carry;
            ListNode node = new ListNode(cur % 10);
            p.next = node;
            p = node;
            carry = cur / 10;
            p1 = p1.next;

        }
        while(p2 != null){
            int cur = p2.val + carry;
            ListNode node = new ListNode(cur % 10);
            p.next = node;
            p = node;
            carry = cur / 10;
            p2 = p2.next;
        }
        if (carry != 0){
            ListNode node = new ListNode(carry);
            p.next = node;
        }
        return ans.next;*/
        int carry = 0;
        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        while(l1 != null || l2 != null){        //时间：O(max(m, n))， 空间 ：O(1)
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            p.next = new ListNode(sum);
            p = p.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry != 0){
            p.next = new ListNode(carry);
        }

        return ans.next;
    }
}
