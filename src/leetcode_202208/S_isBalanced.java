package leetcode_202208;


import sun.reflect.generics.tree.ReturnType;

/**
 * @program: leetcode_fh
 * @description: 判断一个树是否为平衡二叉树
 * @author: fanghao
 * @create: 2022-08-05 14:52
 **/

public class S_isBalanced {
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
    public boolean isBalanced(TreeNode node){
        return process(node).isBalanced;
    }
    public class ReturnType{
        public boolean isBalanced;
        public int height;
        public ReturnType(boolean isB, int height){
            isBalanced = isB;
            this.height = height;
        }
    }
    private ReturnType process(TreeNode node) {
        if (node == null){
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}
