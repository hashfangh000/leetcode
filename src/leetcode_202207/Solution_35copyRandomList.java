package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @author: fanghao
 * @create: 2022-07-28 13:56
 **/

public class Solution_35copyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node p = head;
        while(p != null){
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        Node q = head;
        while(q.next.next != null){
            if(q.random != null){
                q.next.random = q.random.next;
            }
            q = q.next.next;
        }

        Node res = head.next;
        Node cur = head;
        Node next = null;
        Node copy = null;
        // 老 新 混在一起，next方向上，random正确
        // next方向上，把新老链表分离
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;


    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.next = node2;
        node2.next = node3;
        node.random = node3;
        node2.random = node;
        Solution_35copyRandomList solution = new Solution_35copyRandomList();
        solution.copyRandomList(node);
    }
}
