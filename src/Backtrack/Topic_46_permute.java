package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Topic_46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            return ans;
        }
        boolean[] visit = new boolean[len];

//        backtracking(nums, ans, new ArrayList<>(), 0, len, visit);
        backtracking2(nums, ans, current, 0, len, visit);
        return ans;
    }

    private void backtracking2(int[] nums, List<List<Integer>> ans, List<Integer> current, int depth, int len, boolean[] visit) {
        if (depth == len){
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < len; i++){
            if (!visit[i]){
                current.add(nums[i]);
                visit[i] = true;

                backtracking2(nums, ans, current, depth + 1, len, visit);
                visit[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    private void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> current) {
        if (current.size() == nums.length){
            ans.add(new ArrayList<>(current));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(current.contains(nums[i])){
                    continue;
                }
                current.add(nums[i]);
                backtracking(nums, ans, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Topic_46_permute solution = new Topic_46_permute();
        List<List<Integer>> ans = solution.permute(new int[]{1, 1, 2});
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}
