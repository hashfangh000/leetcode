package leetcode_202207;

import java.util.List;

/**
 * @program: leetcode_202207
 * @description: https://leetcode.cn/problems/sort-list/
 * @author: fanghao
 * @create: 2022/7/2 18:04
 * 对链表进行排序
 */
public class Solution_148sortList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
     public ListNode sortList(ListNode head) {
         return process(head, null);
     }

     public ListNode process(ListNode head, ListNode tail){
         if (head == null) {
             return head;
         }
         if (head.next == tail) {
             head.next = null;
             return head;
         }
         ListNode slow = head, fast = head;
         while (fast != tail) {
             slow = slow.next;
             fast = fast.next;
             if (fast != tail) {
                 fast = fast.next;
             }
         }
         ListNode mid = slow;
         ListNode list1 = process(head, mid);
         ListNode list2 = process(mid, tail);
         ListNode sorted = merge(list1, list2);
         return sorted;

     }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode nhead = new ListNode(0);
        ListNode temp = nhead, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null){
            if(p1.val <= p2.val){
                temp.next = p1;
                p1 = p1.next;
            }else{
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        if (p1 != null){
            temp.next = p1;
        }else if (p2 != null){
            temp.next = p2;
        }
        return nhead.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        ListNode next1 = new ListNode(1);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
//        ListNode next4 = new ListNode(7);
        root.next = next1; next1.next = next2; next2.next = next3;
//        next3.next = next4;
        Solution_148sortList solution_148sortList = new Solution_148sortList();
        ListNode head = solution_148sortList.sortList(root);
        System.out.println(head);
    }
}