package leetcode_202208;

/**
 * @program: leetcode_fh
 * @description: 判断树是否为搜索二叉树 树dp
 *                  左是搜索二叉树，右也是
 *                  左的最大值小于我，右的最小值，大于我
 *
 * @author: fanghao
 * @create: 2022-08-05 15:18
 **/

public class S_isBST {
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
    public class ReturnData{
        public boolean isBST;
        public int min;
        public int max;
        public ReturnData(boolean is, int mi, int ma){
            isBST = is;
            min = mi;
            max = ma;
        }
    }
    public ReturnData process(TreeNode x){
        if(x == null){
            return null;
        }
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);
        int min = x.val;
        int max = x.val;
        if (leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null){
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

//        boolean isBST = true;
//        if(leftData != null && (!leftData.isBST || leftData.max >= x.val)){
//            isBST = false;
//        }
//        if(rightData != null && (!rightData.isBST || rightData.min <= x.val)){
//            isBST = false;
//        }
        boolean isBST = false;
        if ((leftData != null ? (leftData.isBST && leftData.max < x.val) : true)
            && (rightData != null ? (rightData.isBST && rightData.min < x.val) : true)){
            isBST = true;
        }
        return new ReturnData(isBST, min, max);
    }
}
