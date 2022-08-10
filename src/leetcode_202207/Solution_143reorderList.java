package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/reorder-list/
 * @author: fanghao
 * @create: 2022-07-04 14:28
 **/

public class Solution_143reorderList {
    public static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode findmid(ListNode head){
        ListNode fast = head, slow = head;
        //查找链表中间节点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //反转链表
    public ListNode reverseList(ListNode head){
        ListNode rehead = null;
        while(head != null){
            ListNode p = head;
            head = head.next;
            p.next = rehead;
            rehead = p;
        }
        return rehead;
    }

    //合并两个链表
    public void mergeList(ListNode list1, ListNode list2){
        //合并两个链表
        ListNode nhead = new ListNode(0);
        ListNode temp = nhead, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null){
            temp.next = p1;
            p1 = p1.next;
            temp = temp.next;
            temp.next = p2;
            p2 = p2.next;
            temp = temp.next;
        }
        if (p1 != null){
            temp.next = p1;
        }else if (p2 != null){
            temp.next = p2;
        }
    }
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = findmid(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;
        mergeList(list1, reverseList(list2));
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;
        Solution_143reorderList solution_143reorderList = new Solution_143reorderList();
        solution_143reorderList.reorderList(node1);
    }
}
