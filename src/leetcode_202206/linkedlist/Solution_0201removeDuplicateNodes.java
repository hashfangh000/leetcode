package leetcode_202206.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/remove-duplicate-node-lcci/
 * @author: fanghao
 * @create: 2022-06-23 20:59
 **/

public class Solution_0201removeDuplicateNodes {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.val);
        ListNode pos = head;
        // 前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode current = pos.next;
            if (set.add(current.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }
}
