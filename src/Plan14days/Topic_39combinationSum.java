package Plan14days;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class Topic_39combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            path.addLast(candidates[i]);
            backtrack(candidates, i, path, ans, target - candidates[i]);
            //删除最后一个 什么时候删除： 2,2,2的时候删除 并非2,2,2,2  注重理解  2,2,3的时候return 到target=5的时候 删除最后一个后：2
            path.removeLast();
        }
    }
}
