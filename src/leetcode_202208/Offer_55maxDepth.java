package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 * @author: fanghao
 * @create: 2022/8/12
 **/
public class Offer_55maxDepth {
    /** Definition for a binary tree node.*/
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }

    public int maxDepth(TreeNode root) {
         if (root == null){
             return 0;
         }
         int leftDepth = maxDepth(root.left) + 1;
         int rightDepth = maxDepth(root.right) + 1;
         return Math.max(leftDepth, rightDepth);
    }
}
