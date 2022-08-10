package leetcode_202207;


/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author: fanghao
 * @create: 2022-07-04 15:30
 **/

public class Solution_142detectCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        /*
        ListNode fast = head.next, slow = head;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;
        return findSameNode(list1, list2);*/
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    private ListNode findSameNode(ListNode list1, ListNode list2) {
        ListNode pa = list1, pb = list2;
        while (pa != pb){
            pa = pa == null ? list2 : pa.next;
            pb = pb == null ? list1 : pb.next;
        }
        return pa;
    }
}
