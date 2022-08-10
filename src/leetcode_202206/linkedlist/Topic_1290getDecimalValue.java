package leetcode_202206.linkedlist;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @author: fanghao
 * @create: 2022-06-08 14:26
 **/

public class Topic_1290getDecimalValue {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int getDecimalValue(ListNode head) {
        ListNode newhead  = null;
        ListNode pre = head;
        while(pre != null){
            ListNode prenext = pre.next;
            pre.next = newhead;
            newhead = pre;
            pre = prenext;
        }
        int ans = 0, i = 0;
        while (newhead != null){
            ans = ans + newhead.val * pow(2, i);
            newhead = newhead.next;
            i++;
        }
        return ans;
    }
    //a的b次方
    int pow(int a, int b){
        if (b == 0){
            return 1;
        }
        if (b % 2 == 0){
            return pow(a, b / 2) * pow(a, b / 2);
        }else{
            return pow(a, b / 2) * pow(a, b / 2) * a;
        }
    }

    public static void main(String[] args) {
        Topic_1290getDecimalValue solution = new Topic_1290getDecimalValue();
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(0);
        ListNode next2 = new ListNode(1);
        ListNode next3 = new ListNode(1);
        head.next = next1;next1.next = next2; next2.next = next3;
        System.out.println(solution.getDecimalValue(head));
//        System.out.println(solution.pow(2, 5));
    }
}
