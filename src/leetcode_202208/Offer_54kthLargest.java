package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @author: fanghao
 * @create: 2022/8/10
 **/
public class Offer_54kthLargest {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int ans, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.right);
        if(k == 0){
            return;
        }
        k = k - 1;
        if(k == 0){
            ans = root.val;
        }
        inOrder(root.left);
    }
}
