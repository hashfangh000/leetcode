package Plan14days;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Topic_47permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0){
            return ans;
        }
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[len];
        backtracking(ans, nums, 0, len, path, visit);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, int[] nums, int depath, int len, Deque<Integer> path, boolean[] visit) {
        if (depath == len){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++){
            if (visit[i]){
                continue;
            }
            if (i > 0 && !visit[i - 1] && nums[i - 1] == nums[i]){
                continue;
            }
            path.addLast(nums[i]);
            visit[i] = true;
            backtracking(ans, nums, depath + 1, len, path, visit);
            path.removeLast();
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        Topic_47permuteUnique solution = new Topic_47permuteUnique();
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = solution.permuteUnique(nums);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
