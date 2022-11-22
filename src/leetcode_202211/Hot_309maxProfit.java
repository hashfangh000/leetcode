package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/18
 *
 * 分为三个状态，买 卖 持有
 * 0, 没有股票 ：，昨天分为 没卖股票和卖股票，今天的钱和昨天的钱一样 ，或者今天的钱和昨天卖出的一样   max(dp[i - 1][0], dp[i - 1][2])
 * 1, 持有 ： 分为今天刚买和昨天就有，昨天有多少钱和今天买了还有多少钱，max(dp[i-1][1] - prices[i]，dp[i - 1][0]) 今天刚买 昨天不能卖,括号顺序不能反
 * 2, 卖 ：由于今天卖的，总收益是dp[i - 1][1] + prices[i]
 **/
public class Hot_309maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0]=0;             //  本来就没有股票
        dp[0][1]=-1*prices[0];  //持有股票 1，昨天就有，但没有卖，今天继承昨天的；2 昨天没得 今天刚买， 今天刚买 今天没有收益 所以是 -1， 第一天的昨天肯定是没得
        dp[0][2]=0;             //卖了

        for(int i = 1; i < n; ++i){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}
