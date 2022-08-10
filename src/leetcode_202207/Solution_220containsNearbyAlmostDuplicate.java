package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/contains-duplicate-iii/
 * @author: fanghao
 * @create: 2022-07-21 21:35
 **/

public class Solution_220containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean res = false;
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (Math.abs(i - j) <= k && (long)Math.abs(nums[i] - nums[j]) <= t){
                    res = true;
                }
            }
        }
        return res;
    }
}
