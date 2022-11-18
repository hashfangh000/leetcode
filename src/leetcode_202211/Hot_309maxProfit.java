package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/18
 **/
public class Hot_309maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0]=0;             //  本来就没有股票
        dp[0][1]=-1*prices[0];  //有股票 1，昨天就有，但没有卖，今天继承昨天的；2 昨天没得 今天刚买
        dp[0][2]=0;             //今天买了又卖了， 或者 昨天有，今天买了也卖了

        for(int i = 1; i < n; ++i){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
}
