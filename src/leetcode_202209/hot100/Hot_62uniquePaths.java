package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/unique-paths/
 * @author: fanghao
 * @create: 2022/9/27
 * 定义dp[i,j]表示从(0,0)走到(i,j)的不同路径，
 * 只能向右和下，0<=i<=m, o<=j<=n
 * i=0时，只能向右，dp[i,j]=1
 * j=0时，只能向下，dp[i,j]=1
 * 除此之外，dp[i][j] = dp[i-1][j] + dp[i][j-1]
 **/
public class Hot_62uniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n -1];
    }
}
