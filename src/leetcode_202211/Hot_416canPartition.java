package leetcode_202211;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/partition-equal-subset-sum/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/22
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 转化为 给一个只包含正整数的非空数组nums, 判断是否能从数组中选取一些数字 使得这些数字的和等于整个数组的元素和的一半。可以转化为0-1背包问题，要求选取的数字和恰好为整个数组的元素和的一半
 * n < 2 不能分割 false
 * 计算整个数组的元素和sum,和最大元素maxNum.如果sum是奇数，不能分割，false，
 * 如果sum是偶数，令target = sum / 2，如果target < maxNum，删除掉maxNum后，所有的元素之和一定小于target,false
 * 创建dp，包含n行，target + 1列，表示从数组的[0,i]下标范围内选取若干个正整数（0）， 是否存在一种选取方案使得选取的正整数的和等于j.初识时 dp的全部元素都是false
 *
 * 边界情况
 *      1。如果不选取任何正整数，则被选取的正整数等于0, 则有dp[i][0] = true
 *      2 i == 0， 只有一个正整数nums[0] 可以被选取，有 dp[0][nums[0]] = true;
 * i > 0 j > 0
 *      1。 j >= nums[i] 还可以选数字。对于当前i，可以选，也可以不选
 *          选取：dp[i][j] = dp[i - 1][j - nums[i]]
 *          不选取：dp[i][j] = dp[i - 1][j];
 *      2. j < nums[i] 不能再选了 dp[i][j] = dp[i - 1][j]
 *
 *
 *  dp[n - 1][target]
 **/
public class Hot_416canPartition {
    public static boolean canPartition(int[] nums) {

        int n = nums.length;
        if(n == 1){
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        if(maxNum > target){
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; ++i){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; ++i){
            int num = nums[i];
            for (int j = 1; j <= target; ++j){
                if (j >= num){
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];

                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 11, 5, 5};
        canPartition(nums);
    }
}
