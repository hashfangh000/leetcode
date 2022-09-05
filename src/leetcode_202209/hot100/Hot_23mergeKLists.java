package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/merge-k-sorted-lists/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/4
 **/
public class Hot_23mergeKLists {
    /**
     * Definition for singly-linked list.     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        ListNode l1 = lists[0];
        //两两合并
        for (int i = 1; i < lists.length; i++){
            l1 = mergeTwoLists(l1, lists[i]);
        }
        return l1;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }else if(list1.val < list2.val){        //l1 小于 l2的话，让l1的下一个和 l2 比较，返回l1，作为当前节点.next
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
