package leetcode_202207;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/complete-binary-tree-inserter/
 * @author: fanghao
 * @create: 2022-07-25 13:31
 **/

public class Solution_919CBTInserter {
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
    Queue<TreeNode> candidate;
    TreeNode root;
    public Solution_919CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }
    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;
        Solution_919CBTInserter solution = new Solution_919CBTInserter(root);

        int parm_1 = solution.insert(3);
        System.out.println(parm_1);
    }
}
