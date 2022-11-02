package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/merge-k-sorted-lists/
 * @author: fanghao
 * @create: 2022/11/1
 * 多路合并k个升序链表，二路递归排序
 **/
public class Hot_23mergeKLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    //多路合并
    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left > right){
            return null;
        }else if(left == right){
            return lists[left];
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
