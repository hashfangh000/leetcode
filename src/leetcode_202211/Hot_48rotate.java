package leetcode_202211;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/rotate-image/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/3
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 将矩阵上下翻转之后，再对角线反转
 **/
public class Hot_48rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先上下翻转
        for(int i = 0; i < n >> 1; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        //对角线翻转
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{2,3}};
        System.out.println(Arrays.toString(nums[0]));
    }
}
