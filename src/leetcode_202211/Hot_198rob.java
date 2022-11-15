package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/house-robber/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/15
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * [1,2,3,1]
 * 输出：4
 * 动态规划，dp[i]为 偷到第i个房屋所偷到第最大金额，
 * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
 **/
public class Hot_198rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i < n; ++i){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

}
