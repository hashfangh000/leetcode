package leetcode_202205;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Topic_222countNodes {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public int countNodes(TreeNode root) {

        int res = 0;
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res++;
            if (node.left != null){
                queue.offer(node.left);
            }if (node.right != null){
                queue.offer(node.right);
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
