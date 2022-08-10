package leetcode_202112;


import java.util.ArrayList;
import java.util.List;


public class Topic_144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }

    public static void main(String[] args) {
        Topic_144_preorderTraversal solution = new Topic_144_preorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        root.right.right=null;
        List<Integer> list = solution.preorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}