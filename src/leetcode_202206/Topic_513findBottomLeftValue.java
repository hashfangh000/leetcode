package leetcode_202206;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @author: fanghao
 * @create: 2022-06-22 10:13
 **/

public class Topic_513findBottomLeftValue {
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
    }
    /*int curval = 0;
    int curheigh = 0;
    public int findBottomLeftValue(TreeNode root) {
        DFS(root, 0);
        return curval;
    }

    private void DFS(TreeNode root, int level) {
        if (root == null){
            return;
        }
        level++;
        DFS(root.left, level);
        DFS(root.right, level);
        if (level > curheigh){
            curheigh = level;
            curval = root.val;
        }
    }*/
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode last = queue.poll();
            if (last.right != null){
                queue.offer(last.right);
            }
            if (last.left != null){
                queue.offer(last.left);
            }
            ans = last.val;
        }
        return ans;
    }
}
