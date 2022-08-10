package DFS;

/**
 * https://leetcode-cn.com/problems/path-sum/
 */
public class Topic_112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return DFS(root,targetSum);
    }

    private boolean DFS(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (targetSum == root.val && root.left == null && root.right == null){
            return true;
        }
        return DFS(root.left,targetSum - root.val) || DFS(root.right,targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(1);
        root.left.left = null;
        root.left.right = null;
        root.right=new TreeNode(2);
        root.right.left= null;
        root.right.right=null;
        Topic_112_hasPathSum solution = new Topic_112_hasPathSum();
        System.out.println(solution.hasPathSum(root,5));
    }
}
