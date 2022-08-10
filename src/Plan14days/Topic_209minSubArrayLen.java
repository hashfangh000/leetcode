package Plan14days;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Topic_209minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        //滑动窗口
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
//        if (ans == Integer.MAX_VALUE){
//            return 0;
//        }else {
//            return ans;
//        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static void main(String[] args) {
        Topic_209minSubArrayLen solution = new Topic_209minSubArrayLen();
        int[] nums = {1,2, 3, 4, 5};
        System.out.println(solution.minSubArrayLen(15, nums));
    }

}
