package leetcode_202211;

import leetcode_202210.Hot_23mergeKLists;

import java.util.List;

/**
 * @description: https://leetcode.cn/problems/sort-list/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/14
 * 对链表进行归并排序，找到链表中点，一分为二
 * 对两个子链表进行排序
 * 合并两个有序链表
 **/
public class Hot_148sortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        return process(head, null);
    }

    private ListNode process(ListNode head, ListNode tail) {
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while(fast != tail){
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = process(head, mid);
        ListNode list2 = process(mid, tail);
        ListNode sorted = mergeTwoLists(list1, list2);
        return sorted;
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
