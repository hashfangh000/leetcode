package leetcode_202207;


import java.util.ArrayDeque;

import java.util.Queue;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/binary-tree-pruning/
 * @author: fanghao
 * @create: 2022-07-21 13:43
 **/

public class Solution_814pruneTree {
    //Definition for a binary tree node.
    public static class TreeNode {
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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution_814pruneTree solution = new Solution_814pruneTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);

        root.right = node1;
        node1.left = node2;
        node1.right = node3;
    }
}
