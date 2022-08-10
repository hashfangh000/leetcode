package leetcode_202112;

import java.util.ArrayList;
import java.util.List;

public class Topic_145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        Topic_145_postorderTraversal solution = new Topic_145_postorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        root.right.right=null;
        List<Integer> list = solution.postorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}