package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/maximum-product-subarray/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/15
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 * nums = [5,6,−3,4,−3]
 * 输出: 5×6×(−3)×4×(−3)
 * 当前位置的数num
 * num > 0 我们希望它前一个位置的某个子序列也为正数，且正的越大 2者相乘就越大
 * num < 0 我们希望它前一个位置的某个序列为负数，且希望负的越多，2者相乘就越多
 *
 * 定义maxF和minF两个数组，max[i]表示第i位置结尾的乘积最大子序列，min[i]表示 第 i 个位置结尾的乘积最小的子序列，
 *  对于maxF 有三个可以成为最大乘积的子序列,分num[i]正负讨论，
 *    maxF
 *      nums[i] > 0 ：maxF[i-1] * nums[i]肯定是大的
 *      nums[i] < 0 : 找nums[i]和minF[i - 1] * nums[i]的最大值，因为minF[i]表示很小的负数，所以乘num[i]， 负负得正，
 *                      这里要跟num[i]本身比，一个数，乘以一个负数是不是比自己大，8 * -2 和 -2 比较
 *
 *   minF
 *      nums[i] > 0 ：minF[i-1] * nums[i] 肯定负的更多
 *      nums[i] < 0 : 比较num[i] 和maxF[i-1] * nums[i]的值，   maxF表示最大的正数，乘以小于0的数nums[i] 结果更小
 **/
public class Hot_152maxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums, 0, maxF, 0, n);
        System.arraycopy(nums, 0, minF, 0, n);

        for(int i = 1; i < n; i++){
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < n; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}
