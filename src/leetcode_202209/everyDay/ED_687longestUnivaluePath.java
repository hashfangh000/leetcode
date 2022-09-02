package leetcode_202209.everyDay;

/**
 * @description: https://leetcode.cn/problems/longest-univalue-path/
 * @author: fanghao
 * @create: 2022/9/2
 * 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度由它们之间的边数表示。
 *
 *
 **/
public class ED_687longestUnivaluePath {
    /**
     * Definition for a binary tree node.*/
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
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        process(root);
        return res;

    }

    private int process(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftPath = process(root.left);
        int rightPath = process(root.right);
        int leftMaxPath = 0, rightMaxPath = 0;
        if (root.left != null && root.left.val == root.val){
            leftPath = leftMaxPath + 1;
        }
        if (root.right != null && root.right.val == root.val){
            rightPath = rightMaxPath + 1;
        }
        res = Math.max(res, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
