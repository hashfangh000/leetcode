package leetcode_202209.hot100;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/rotate-image/
 * @author: fanghao
 * @create: 2022/9/19
 **/
public class Hot_48rotate {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                tmp[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
