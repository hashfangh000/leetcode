package DFS;

public class Topic_98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return DFS(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean DFS(TreeNode root, long lower, long upper) {
        if (root == null){
            return true;
        }
        if (root.val <= lower || root.val >= upper){
            return false;
        }
        return DFS(root.left,lower, root.val) && DFS(root.right, root.val, upper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left=new TreeNode(1);
        root.left.left = null;
        root.left.right = null;
        root.right=new TreeNode(3);
        root.right.left= null;
        root.right.right=null;
        Topic_98_isValidBST solution = new Topic_98_isValidBST();
        System.out.println(solution.isValidBST(root));
    }
}
