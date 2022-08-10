package leetcode_202206.jzofferII;

import leetcode_202206.jzoffer.Solution_52;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/3u1WK4/
 * @author: fanghao
 * @create: 2022-06-08 15:11
 **/

public class Solution_23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //让长的链表先走两链表长度之差的步数，再一起走
    //
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
