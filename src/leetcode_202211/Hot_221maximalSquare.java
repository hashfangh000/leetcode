package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/maximal-square/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/16
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 遍历矩阵中的每个元素，每次遇到 111，则将该元素作为正方形的左上角；
 * 确定正方形的左上角后，根据左上角所在的行和列计算可能的最大正方形的边长（正方形的范围不能超出矩阵的行数和列数），在该边长范围内寻找只包含 111 的最大正方形
 * 每次在下方新增一行以及在右方新增一列，判断新增的行和列是否满足所有元素都是 111
 **/
public class Hot_221maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(matrix[i][j] == '1'){
                    maxSide = Math.max(1, maxSide);         //等于1 边长至少为1，或者更大

                    int currentMaxSide = Math.min(rows - i, columns - j);      //(i, j)为正方形的左上角，记currentMaxSide其能够达到的最大边长
                    //判断新增一列 一行 是否都是1
                    for(int k = 1; k < currentMaxSide; k++){
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0'){               //先判断正方形的右下角是不是 0
                            break;
                        }
                        //再判断 正方形的最下的行，最右的列 是否为 0
                        for (int m = 0; m < k; m++){
                            if(matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);         //k + 1 其中k表示 扩充的边长， 加1表示本身的边长为1
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}
