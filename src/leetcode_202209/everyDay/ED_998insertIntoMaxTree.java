package leetcode_202209.everyDay;

/**
 * @description: https://leetcode.cn/problems/maximum-binary-tree-ii/
 * @author: fanghao
 * @create: 2022/8/30
 **/
public class ED_998insertIntoMaxTree {
    /**
     Definition for a binary tree node. */
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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }else{
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
