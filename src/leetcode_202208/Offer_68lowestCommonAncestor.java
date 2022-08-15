package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author: fanghao
 * @create: 2022/8/13
 **/
public class Offer_68lowestCommonAncestor {
    /**
     * Definition for a binary tree node.*/
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;*/
        while(root != null) {
            if ((p.val - root.val) * (q.val - root.val) <= 0) return root;
            else root = p.val > root.val ? root.right : root.left;
        }
        return root;
    }
}
