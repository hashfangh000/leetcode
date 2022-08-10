package leetcode_202208;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @author: fanghao
 * @create: 2022-08-04 12:41
 **/

public class Offer_47maxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 2][n + 2];
        dp[1][1] = grid[0][0];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Offer_47maxValue s = new Offer_47maxValue();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        s.maxValue(grid);
    }
}
