package leetcode_202208;

import DFS.TreeNode;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author: fanghao
 * @create: 2022/8/10
 **/
public class Offer_34pathSum {
    public static class TreeNode {
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
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtracking(root, target);
        return ans;
    }

    private void backtracking(TreeNode root, int target) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            ans.add(new LinkedList<>(path));
        }
        backtracking(root.left, target);
        backtracking(root.right, target);

        path.removeLast();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(2);
        root.left.left = null;
        root.left.right = null;
        root.right=new TreeNode(2);
        root.right.left= null;
        root.right.right=null;
        Offer_34pathSum solution = new Offer_34pathSum();
        List<List<Integer>> list = solution.pathSum(root, 5);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println(integer + " ");
            }
            System.out.println("======================");
        }
    }
}
