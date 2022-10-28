package leetcode_202210;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/permutations-ii/
 * @author: fanghao
 * @create: 2022/10/27
 *
 * 全排列二， 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * [1, 1, 2]
 *
 * [[1, 1, 2],
 *  [1, 2, 1],
 *  [2, 1, 1]]
 **/
public class Hot_47permuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> cur = new LinkedList<>();
        boolean[] visited = new boolean[len];
        Arrays.sort(nums);
        backtracking(nums, visited, ans, cur, len, 0);
        return ans;
    }

    private static void backtracking(int[] nums, boolean[] visited, List<List<Integer>> ans, Deque<Integer> cur, int len, int depth) {
        if (depth == len){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < len; i++){
            if (visited[i]){
               continue;
            }
            if (i > 0 && !visited[i - 1] && nums[i - 1] == nums[i]){
                continue;
            }
            cur.offerLast(nums[i]);
            visited[i] = true;
            backtracking(nums, visited, ans, cur, len, depth + 1);
            cur.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        permuteUnique(nums);

    }
}
