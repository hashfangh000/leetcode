package leetcode_202206.jzoffer;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @author: fanghao
 * @create: 2022-06-08 15:00
 * 剑指offer 52
 **/

public class Solution_52 {
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
