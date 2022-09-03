package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/3
 **/
public class Hot_19removeNthFromEnd {
    /**
     * Definition for singly-linked list.*/
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0, head);   //定义一个head 不存值
        ListNode fast = head;
        ListNode slow = dummy;
        while(n > 0){
            n--;
            fast = fast.next;
        }
        //slow.next 为待删节点
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
