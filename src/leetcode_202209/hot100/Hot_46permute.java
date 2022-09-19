package leetcode_202209.hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/permutations/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/19
 * 全排列问题，不含有重复数字的数组
 **/
public class Hot_46permute {


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        int len = nums.length;
        boolean[] visited = new boolean[nums.length];
        backtracking(ans, path, nums, visited, len, 0);
        return ans;
    }

    private static void backtracking(List<List<Integer>> ans, Deque<Integer> path, int[] nums, boolean[] visited, int len, int depth) {
        if (depth == len){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                backtracking(ans, path, nums, visited, len, depth + 1);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
}
