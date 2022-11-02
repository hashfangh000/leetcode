package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @author: fanghao
 * @create: 2022/11/1
 * K 个一组反转链表，先找第一组，反转之后更新位置，再找第二组，在找的过程中如果遇到空，直接返回
 * 定义一个新的头dummy, 使得dummy.next = head,
 * 定义pre = dummy，
 *
 * 每次在找k个节点时，用head,tail 标记，并定义一个节点nex = tail.next, 反转后用于拼接 也用head， tail 标记，再将其拼接到dummy中，有：
 *                                                                      pre.next = head
 *                                                                      tail.next = nex
 *
 *                                                                      然后更新pre，head, tail的位置
 *                                                                      pre = tail;
 *                                                                      head = tail.next;
 *
 **/
public class Hot_25reverseKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while(head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++){
                tail = tail.next;
                if (tail == null){                  //不足k个，返回
                    return dummy.next;
                }
            }
            ListNode nex = tail.next;               //用于反转后拼接
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            //拼接
            pre.next = head;
            tail.next = nex;
            //更新pre,head 位置
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    //将head...tail 反转，返回tail...head
    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (tail != prev){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

}
