package Plan14days;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Topic_40combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<>();          //当前符合条件的组合
        int len = candidates.length;
        Arrays.sort(candidates);
        if (len == 0){
            return ans;
        }
        backtrack(candidates, 0, path, ans, target);
        return ans;
    }

    private void backtrack(int[] candidates, int begin, Deque<Integer> path, List<List<Integer>> ans, int target) {
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++){

            if (candidates[i] > target){
                return;
            }
            if (i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.addLast(candidates[i]);
            backtrack(candidates, i + 1, path, ans, target - candidates[i]);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Topic_40combinationSum2 solution = new Topic_40combinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> ans = solution.combinationSum2(candidates, 8);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}
