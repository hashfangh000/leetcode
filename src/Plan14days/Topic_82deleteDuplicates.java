package Plan14days;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Topic_82deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode p = newHead;
        while (p.next != null && p.next.next != null){
            if (p.next.val == p.next.next.val){
                int current = p.next.val;
                while (p.next != null && p.next.val == current){
                    p.next = p.next.next;
                }
            }else{
                p = p.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Topic_82deleteDuplicates solution = new Topic_82deleteDuplicates();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        solution.deleteDuplicates(node1);
    }
}
