package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class Topic_78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();

        backtracking(ans, current, nums, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> current, int[] nums, int begin) {
        ans.add(new ArrayList<>(current));
        for (int i = begin; i < nums.length; i++){
            current.add(nums[i]);
            backtracking(ans, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Topic_78_subsets solution = new Topic_78_subsets();
        List<List<Integer>> ans = solution.subsets(new int[]{1,2,3,4});
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}
