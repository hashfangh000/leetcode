package leetcode_202210;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/permutations/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/26
 * 全排列问题，给定nums,其中所有数字互不相同，返回其所有排列后的结果
 **/
public class Hot_46permute {
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> cur = new LinkedList<>();

        if (len == 0){
            return ans;
        }
        backtracking(nums, ans, cur, len);
        return ans;
    }

    private static void backtracking(int[] nums, List<List<Integer>> ans, Deque<Integer> cur, int len) {
        if (len == cur.size()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < len; i++){          //排列不需要定义i的位置，由于是全排列
            if (cur.contains(nums[i])){
                continue;
            }
            cur.offerLast(nums[i]);
            backtracking(nums, ans, cur, len);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
    }
}
