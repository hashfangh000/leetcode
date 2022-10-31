package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/31
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 重新定义一个头部，使用快慢指针，倒数第n个，先让快指针走n步，再快慢指针一起走，直到快指针为空时，停止，此时快指针为空，满指针为倒数第n个位置第前一个位置
 **/
public class Hot_19removeNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = head;
        while (n > 0){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
