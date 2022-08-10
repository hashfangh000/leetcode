package leetcode_202208;

import leetcode_202206.linkedlist.Topic_1290getDecimalValue;

import java.util.List;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @author: fanghao
 * @create: 2022-08-05 11:28
 **/

public class Offer_25mergeTwoLists {
    /**
     * Definition for singly-linked list.*/
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode nhead = new ListNode(-1);
        ListNode np = nhead;
        while(p1 != null && p2 != null){
            if(p1.val > p2.val){
                ListNode node = new ListNode(p2.val);
                np.next = node;
                p2 = p2.next;
            }else{
                ListNode node = new ListNode(p1.val);
                np.next = node;
                p1 = p1.next;
            }
            np = np.next;
        }
        if (p1 == null){
            np.next = p2;
        }
        if (p2 == null){
            np.next = p1;
        }
        return nhead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new  ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        head1.next = next1;next1.next = next2;

        ListNode head2 = new  ListNode(1);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        head2.next = next3;next3.next = next4;
        Offer_25mergeTwoLists so = new Offer_25mergeTwoLists();
        so.mergeTwoLists(head1, head2);
    }
}
