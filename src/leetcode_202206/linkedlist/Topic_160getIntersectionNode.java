package leetcode_202206.linkedlist;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 查找两个相交链表的起始结点
 *
 * @author fanghao on 2022/6/6
 */
public class Topic_160getIntersectionNode {
    public class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*int m = 0, n = 0;
        ListNode p = headA, q = headB;

        while (headA != null){
            m++;
            headA = headA.next;
        }
        while (headB != null){
            n++;
            headB = headB.next;
        }
        if (m > n) {
            while (m - n > 0){
                p = p.next;
                m--;
            }
        }else {
            while (m - n < 0){
                q = q.next;
                n--;
            }
        }
        while (p != null && q != null){
            if (p != q){
                p = p.next;
                q = q.next;
            }else{
                return p;
            }
        }
        return null;*/
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