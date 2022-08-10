package leetcode_202206.linkedlist;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/
 * @author: fanghao
 * @create: 2022-06-23 21:06
 * 找链表倒数第k个节点
 * fast先走k步， slow从head开始在一步一步走
 **/

public class Solution_0202kthToLast {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k > 0){
            fast = fast.next;
            k--;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
