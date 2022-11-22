package leetcode_202211;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/coin-change/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/19
 * 定义dp[i] 为组成i金额的最大数量，在计算dp[i] 之前，已经计算了 dp[0] ... dp[i - 1]的答案，dp[i] = min (dp[i - c]) + 1
 * c 代表第j枚硬币的面值，加1就是枚举到的那块硬币, i < 0 忽略dp[i]
 * [1, 2, 5] 11
 * dp[0] = 0
 * dp[1] = min (dp[1 -1], dp[1 - 2], dp[1 - 5]) + 1 = 1
 * dp[2] = min(dp[2 - 1], dp[2 - 2], dp[2 - 5]) + 1 = 1
 * dp[3] = min(dp[3 - 1], dp[3 - 2], dp[3 - 5]) + 1 = 2
 * dp[4] = min(dp[4 - 1], dp[4 - 2], dp[4 - 5]) + 1 = 2
 * dp[5] = min(dp[5 - 1], dp[5 - 2], dp[5 - 5]) + 1 = 1
 *
 * dp[11] = min(dp[11 - 1], dp[11 - 2], dp[11 - 5]) + 1 = 3
 **/
public class Hot_322coinChange {
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i < amount + 1; ++i){
            for (int j = 0; j < coins.length; ++j){
                if(coins[j] <= i){                                  //  忽略dp[i]中 i < 0情况
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        coinChange(coins, 6249);
    }
}
