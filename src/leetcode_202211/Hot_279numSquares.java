package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/perfect-squares/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/18
 **/
public class Hot_279numSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <=n; ++i){
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}
