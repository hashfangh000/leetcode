package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author: fanghao
 * @create: 2022/8/13
 **/
public class Offer_68_II_lowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){  //root为空直接返回
            return null;
        }
        //p 或 q 中有一个等与 root  即返回root
        if (root == p || root == q){
            return root;
        }
        //遍历 左子树和右子树 找到 p 或 q ，找到谁 就先返回谁
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null){  //左子树没找到 p 和 q 一定在右子树
            return right;
        } else if (right == null){
            return left;
        }else {             //左右子树都没找到，在根
            return root;
        }
    }
}
