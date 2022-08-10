package DFS;


public class Topic_404_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? DFS(root) : 0;
    }

    private int DFS(TreeNode root) {
        int ans = 0;
        if (root.left != null){
            ans += isLeafNode(root.left) ? root.left.val : DFS(root.left);    //判断最左叶子节点  并相加
        }
        if (root.right != null && !isLeafNode(root.right)){                    //判断右子树的 左叶子节点  并相加
            ans += DFS(root.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        Topic_404_sumOfLeftLeaves solution = new Topic_404_sumOfLeftLeaves();
        int ans = solution.sumOfLeftLeaves(root);
        System.out.println(ans);
    }
}
