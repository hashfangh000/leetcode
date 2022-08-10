package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Topic_94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(ans,root);
        return ans;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null){
            return;
        }
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
}
