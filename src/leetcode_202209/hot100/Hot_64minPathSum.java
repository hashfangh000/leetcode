package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/minimum-path-sum/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/27
 *
 * 动态规划：定义f(i, j)表示(0,0)到(i,j)的最小路径和，
 * 如果是向右，f(i, j) = f(i, j - 1) + grid[i][j]
 * 如果是向下，f(i, j) = f(i - 1, j) + grid[i][j]
 * f(i, j) = Min(f(i, j - 1),  f(i - 1, j)) + grid[i][j]
 * 对于i = 0， f(0, j) = f(0, j - 1) + grid[i][j]
 * 对于j = 0， f(i, 0) = f(i - 1, 0) + grid[i][j]
 * return f(m - 1, n - 1)
 **/
public class Hot_64minPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //j = 0;
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // i = 0
        for (int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
