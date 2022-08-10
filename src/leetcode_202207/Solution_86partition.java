package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/partition-list/
 * @author: fanghao
 * @create: 2022-07-19 21:33
 *
 * 快速排序——分割
 **/

public class Solution_86partition {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        node.next = node1;
        Solution_86partition solution = new Solution_86partition();
        solution.partition(node, 2);
    }
}
