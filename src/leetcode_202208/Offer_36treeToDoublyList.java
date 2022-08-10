package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @author: fanghao
 * @create: 2022/8/10
 **/
public class Offer_36treeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrder(Node current) {
        if (current == null){
            return;
        }
        //
        inOrder(current.left); // 左

        //中
        if(pre != null){
            pre.right = current;
        }else{
            head = current;
        }
        current.left = pre;
        pre = current;

        //右
        inOrder(current.right);
    }
}
