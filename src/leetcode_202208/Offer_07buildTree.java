package leetcode_202208;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 * @author: fanghao
 * @create: 2022/8/15
 **/
public class Offer_07buildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        int x = preorder[0];
        TreeNode root = new TreeNode(x);
        int pos = 0;
        for (int i = 0; i < inorder.length; i++){
            if (x == inorder[i]){
                pos = i;
                break;
            }
        }
        //递归构建左右子树
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));
        return root;
    }
}
