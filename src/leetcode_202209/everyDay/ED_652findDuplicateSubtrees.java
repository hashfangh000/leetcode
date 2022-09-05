package leetcode_202209.everyDay;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/find-duplicate-subtrees/
 * @author: fanghao
 * @create: 2022/9/5
 **/
public class ED_652findDuplicateSubtrees {
    /**
     * Definition for a binary tree node.*/
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        DFS(root);
        return new ArrayList<TreeNode>(repeat);
    }

    private String DFS(TreeNode node) {
        if (node == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(node.val);
        sb.append("(");
        sb.append(DFS(node.left));
        sb.append(")(");
        sb.append(DFS(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial)){
            repeat.add(seen.get(serial));
        }else{
            seen.put(serial, node);
        }
        return serial;
    }
}
