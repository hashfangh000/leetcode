package Backtrack;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Topic_47_permuteUnique {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//        int len = nums.length;
//        if (len == 0){
//            return ans;
//        }
//        boolean[] visit = new boolean[len];
//        backtracking(nums, ans, current, visit);
//        return ans;
//    }
//
//    private void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> current, boolean[] visit) {
//        if (current.size() == nums.length && !ans.contains(current)){
//            ans.add(new ArrayList<>(current));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (!visit[i]) {
//                current.add(nums[i]);
//                visit[i] = true;
//
//                backtracking(nums, ans, current, visit);
//                visit[i] = false;
//                current.remove(current.size() - 1);
//            }
//        }
//    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[len];
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(nums,len,0, path, isUsed, res);
        return res;
    }
        private void dfs(int[] nums, int len, int depath, Deque<Integer> path, boolean[] isUsed, List<List<Integer>> res) {
            if (len == depath){
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < len; i++){
                //被用过 跳过 保证每一个数都使用一次
                if (isUsed[i]){
                    continue;
                }
                // i > 0 是保证isUsed[i - 1] 有意义，
                //nums[i - 1] == nums[i] 是保证去重
                //!isUsed[i - 1] 是nums[i - 1] 上一个元素已经被撤掉了，当前元素与上一个元素相同 则跳过
                if (i > 0 && !isUsed[i - 1] && nums[i - 1] == nums[i]) {
                    continue;
                }
                path.addLast(nums[i]);
                isUsed[i] = true;
                dfs(nums, len, depath + 1, path, isUsed, res);
                path.removeLast();
                isUsed[i] = false;
            }
        }
    public static void main(String[] args) {
        Topic_47_permuteUnique solution = new Topic_47_permuteUnique();
        List<List<Integer>> ans = solution.permuteUnique(new int[]{1, 1, 2, 2});
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}




