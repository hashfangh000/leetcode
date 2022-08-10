package Plan14days;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * @author fanghao on 2022/3/9
 */
public class Topic_572isSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}