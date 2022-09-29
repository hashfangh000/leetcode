package leetcode_202209.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/subsets/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/29
 **/
public class Hot_78subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();

        backtracking(ans, current, nums, 0);
        return ans;
    }

    private static void backtracking(List<List<Integer>> ans, List<Integer> current, int[] nums, int begin) {
        ans.add(new ArrayList<>(current));
        for(int i = begin; i < nums.length; i++){
            current.add(nums[i]);
            backtracking(ans, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }
}
