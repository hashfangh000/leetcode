package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/maximum-subarray/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/22
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * 定义dp[i]为i开始的最大子数组的和，dp[i] = dp[i-1] + num[i]
 * dp[0] = 0;
 * 对于dp[i] dp[i] = Math.max(dp[i-1] + nums[i] > nums[i] ,nums[i]);
 * 取 下一个数 和 dp[i-1] + nums[i]的最大值 赋值给dp[i] ， 子数组可以为一个数
 * dp 中最大的数即为答案
 **/
public class Hot_53maxSubArray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int tmp = 0;
        for (int i = 0; i < n; i++){
            tmp = Math.max(tmp + nums[i], nums[i]);     //子数组可以为一个数
            max = max > tmp ? max : tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3}));
    }
}
