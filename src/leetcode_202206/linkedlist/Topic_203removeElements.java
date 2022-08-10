package leetcode_202206.linkedlist;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * 删除链表值为val的结点
 * @author fanghao on 2022/6/6
 */
public class Topic_203removeElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        /*if (head == null){
            return null;
        }
        ListNode pre = new ListNode(0, head);
        ListNode p = pre;
        while (p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return pre.next;

         */
        if(head == null)
            return null;
        head.next = removeElements(head.next,val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }
}