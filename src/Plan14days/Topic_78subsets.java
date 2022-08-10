package Plan14days;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class Topic_78subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtracking(ans, current, 0, nums);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> current, int begin, int[] nums) {
        ans.add(new ArrayList<>(current));
        for (int i = begin; i < nums.length; i++){
            current.add(nums[i]);
            backtracking(ans, current, i + 1, nums);
            current.remove(current.size() - 1);
        }
    }
}
