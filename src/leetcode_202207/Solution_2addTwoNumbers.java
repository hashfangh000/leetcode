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
         int carry = 0;
         ListNode ans = new ListNode(-1);
         ListNode p = ans;
         while(l1 != null || l2 != null){        //时间：O(max(m, n))， 空间 ：O(1)
             int x = l1 == null ? 0 : l1.val;
             int y = l2 == null ? 0 : l2.val;
             int sum = x + y + carry;

             carry = sum / 10;
             sum = sum % 10;
             p.next = new ListNode(sum);
             p = p.next;
             if (l1 != null){
                 l1 = l1.next;
             }
             if (l2 != null){
                 l2 = l2.next;
             }
         }
         if (carry != 0){
             p.next = new ListNode(carry);
         }

         return ans.next;
    }
}
