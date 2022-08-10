package leetcode_202205;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topic_235lowestCommonAncestor  {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*List<TreeNode> path_p = getpath(root, p);
        List<TreeNode> path_q = getpath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
         */
        TreeNode ancestor = root;
        while (true){
            if (p.val < ancestor.val && q.val < ancestor.val){
                ancestor = ancestor.left;
            }else if(p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getpath(TreeNode root, TreeNode target) {
      List<TreeNode> path = new ArrayList<>();
      TreeNode node = root;
      while (node != target){
          path.add(node);
          if (node.val > target.val){
              node = node.left;
          } else {
              node = node.right;
          }
      }
      path.add(node);
      return path;
    }
}
