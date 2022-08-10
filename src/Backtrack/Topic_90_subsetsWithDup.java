package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class Topic_90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtracking(ans, current, nums, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> current, int[] nums, int begin) {
        ans.add(new ArrayList<>(current));
        for (int i = begin; i < nums.length; i++){
            if (i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            current.add(nums[i]);
            backtracking(ans, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Topic_90_subsetsWithDup solution = new Topic_90_subsetsWithDup();
        List<List<Integer>> ans = solution.subsetsWithDup(new int[]{1,2,2});
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}
