package leetcode_202205;

import java.util.ArrayList;
import java.util.List;

public class Topic_236lowestCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> path_p = new ArrayList<>();
//        getpath(root, p, path_p);
//        List<TreeNode> path_q = new ArrayList<>();
//        getpath(root, q, path_q);
//        TreeNode ancestor = null;
//        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
//            if (path_p.get(i) == path_q.get(i)) {
//                ancestor = path_p.get(i);
//            } else {
//                break;
//            }
//        }
//        return ancestor;
        if (root == null || (root == p || root ==q)){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }

    private void getpath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null){
            return;
        }
        if (root == p){
            path.add(root);
            return;
        }
        path.add(root);
        getpath(root.left, p, path);
        getpath(root.right, p, path);
        if (path.get(path.size() - 1) != p){
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        //Topic_236lowestCommonAncestor solution = new Topic_236lowestCommonAncestor();
        List<TreeNode> path_p = new ArrayList<>();
//        solution.getpath(root, node4, path_p);
//        for (TreeNode treeNode : path_p) {
//            System.out.println(treeNode.val + ",");
//        }
        Topic_236lowestCommonAncestor.lowestCommonAncestor(root, node2, node3);
    }
}
