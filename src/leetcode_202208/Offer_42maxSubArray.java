package leetcode_202208;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: fanghao
 * @create: 2022-08-04 11:30
 **/

public class Offer_42maxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int former = 0; //dp[i - 1]
        for (int num : nums) {
            former = Math.max(former + num, num);
            max = max > former ? max : former;
        }
        return max;
    }
}
