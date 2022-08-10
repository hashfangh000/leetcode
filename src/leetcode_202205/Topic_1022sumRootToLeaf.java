package leetcode_202205;

/**
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * @author fanghao on 2022/5/30
 */
public class Topic_1022sumRootToLeaf {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public int sumRootToLeaf(TreeNode root) {
            return DFS(root, 0);
        }
    }

    private int DFS(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }
        int n = cur * 2 + root.val;
        if (root.left == null && root.right == null) {
            return n;
        }
        return DFS(root.left, n) + DFS(root.right, n);
    }

}