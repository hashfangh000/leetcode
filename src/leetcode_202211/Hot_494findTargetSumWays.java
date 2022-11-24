package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/target-sum/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/22
 * 记数组元素和为sum， 添加 - 号 的元素之和为 neg， 其余添加 + 的元素之和为 sum - neg
 *  target = (sum - neg) - neg = sum - 2 * neg
 *  neg = (sum - target) / 2， 其中nums的元素都是非负数，neg也必须是非负整数。 sum - target是非负偶数才行
 *  定义dp[i][j] 表示在数组nums的前i个数中选取元素，使得这些元素之和等于j的方案数，假设数组长度为n, 则最终答案为 dp[n][neg]
 *  j = 0, dp[0][j] = 1         没有数选取时 和为0。 方案为1
 *  j >= 1, dp[0][j] = 0        没有数选取时，和为j 不可能，方案为0
 *
 *  1 <= i <= n时，对于nums中的第i个元素num，遍历 0 <= j <= neg 计算dp[i][j]的值
 *      如果 j < num 则不能选num，dp[i][j] = dp[i - 1][j]
 *      如果 j >= num， 可以选 也可以不选，选的话：dp[i][j] = dp[i - 1][j - num]   不选的话 ：dp[i][j] = dp[i - 1][j]， 有
 *          dp[i][j] = dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num]
 **/
public class Hot_494findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0){
            return 0;
        }
//        int n = nums.length, neg = diff / 2;
//        int[][] dp = new int[n + 1][neg + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= n; ++i){
//            int num = nums[i - 1];
//            for (int j = 0; j <= neg; ++j){
//                dp[i][j] = dp[i - 1][j];
//                if (j >= num){
//                    dp[i][j] += dp[i - 1][j - num];
//                }
//            }
//        }
//        return dp[n][neg];
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; --j){
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }

    
}
