package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/add-two-numbers/
 * @author: fanghao
 * @create: 2022-07-21 14:35
 **/

public class Solution_2addTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
          return null;
        } if(l2 == null){
            return null;
        }
        l1.next = addTwoNumbers(l1.next, l2);
        l1.next = addTwoNumbers(l1, l2.next);
        int sum = 0;
        sum += (l1.val + l2.val) / 10;
        l1.val = (l1.val + l2.val) % 10;
        return l1;
    }
}
