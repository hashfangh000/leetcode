package leetcode_202206.linkedlist;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/delete-middle-node-lcci/
 * @author: fanghao
 * @create: 2022-06-23 21:10
 **/

public class Solution_0203deleteNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
