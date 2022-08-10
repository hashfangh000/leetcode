package leetcode_202208;

/**
 * @program: leetcode_fh
 * @description: 判断树是否为满二叉树
 * @author: fanghao
 * @create: 2022-08-05 15:40
 **/

public class S_isF {
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
    public boolean isF(TreeNode head){
        if (head == null){
            return true;
        }
        Info data = process(head);
        return data.nodes == 1 << data.height - 1;
    }

    public class Info{
        public int height;
        public int nodes;

        public Info(int h, int n){
            height = h;
            nodes = n;
        }
    }
    public Info process(TreeNode x){
        if(x == null){
            return new Info(0, 0);
        }
        Info leftData = process(x.left);
        Info rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }
}
