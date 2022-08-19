package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/jian-sheng-zi-lcof/
 * @author: fanghao
 * @create: 2022/8/18
 **/
public class Offer_14_I_cuttingRope {
    public int cuttingRope(int n) {
        /*if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }*/
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++){
            int curMax = 0;
            for(int j = 1; j < i; j++){
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
