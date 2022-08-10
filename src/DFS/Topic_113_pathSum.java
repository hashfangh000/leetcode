package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Topic_113_pathSum {
    Deque<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        DFS(root,targetSum);
        return ans;
    }
    private void DFS(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null){
            ans.add(new LinkedList<Integer>(path));
        }
        DFS(root.left,targetSum);
        DFS(root.right, targetSum);
        path.pollLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(2);
        root.left.left = null;
        root.left.right = null;
        root.right=new TreeNode(2);
        root.right.left= null;
        root.right.right=null;
        Topic_113_pathSum solution = new Topic_113_pathSum();
        List<List<Integer>> list = solution.pathSum(root,5);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println(integer + " ");
            }
            System.out.println("======================");
        }
    }
}
