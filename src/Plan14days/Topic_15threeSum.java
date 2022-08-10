package Plan14days;

import java.util.*;

public class Topic_15threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length  < 3 || nums == null){
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[i]);
                    current.add(nums[left]);
                    current.add(nums[right]);
                    ans.add(current);
                    // 注意在不重复的三元组 如果这个数用过了 就不要再用了 去重
                    /**
                     * 例如 -4, -1, -1, 0, 1, 2*, 2
                     * 当前ans中已经有 -1, -1, 2的三元组
                     * 则下一次就取2*
                     */
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                }else if (sum > 0){
                    right--;
                }
            }
        }
        return ans;
    }
    private void backtracking(List<List<Integer>> ans, int[] nums, int sum, int begin, Deque<Integer> path){
        //List<Integer> path = new ArrayList<>();
        if(path.size() == 3 && sum == 0){
            ans.add(new ArrayList(path));
            return;
        }
        for(int i = begin; i < nums.length; i++){
            if (sum < nums[i]){
                return;
            }
            if(i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            path.addLast(nums[i]);
            backtracking(ans, nums, sum - nums[i], i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Topic_15threeSum solution = new Topic_15threeSum();
        List<List<Integer>> ans = solution.threeSum(new int[]{0,0,0});
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}
