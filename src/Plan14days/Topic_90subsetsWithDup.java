package Plan14days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class Topic_90subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(ans, nums, 0, current);
        return ans;
    }
    private void backtracking(List<List<Integer>> ans, int[] nums, int begin, List<Integer> current){
        ans.add(new ArrayList<>(current));
        for(int i = begin; i < nums.length; i++){
            if(i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            current.add(nums[i]);
            backtracking(ans, nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Topic_90subsetsWithDup solution = new Topic_90subsetsWithDup();
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = solution.subsetsWithDup(nums);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
