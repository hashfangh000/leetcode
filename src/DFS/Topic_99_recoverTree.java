package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class Topic_99_recoverTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        DFS(root,list);                 //asddsadsa
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i).val > list.get(i + 1).val){
                y = list.get(i + 1);
                if (x == null){
                    x = list.get(i);
                }
            }
        }
        if (x != null && y != null){
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
    /**
     * 中序遍历
     */
    private void DFS(TreeNode root, List<TreeNode> list) {
        if (root == null){
            return;
        }
        DFS(root.left,list);
        list.add(root);
        DFS(root.right,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(1);
        root.left.left = null;
        root.left.right = null;
        root.right=new TreeNode(2);
        root.right.left= null;
        root.right.right=null;

        Topic_99_recoverTree solution = new Topic_99_recoverTree();
        solution.recoverTree(root);


    }
}
