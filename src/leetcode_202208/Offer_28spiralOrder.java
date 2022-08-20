package leetcode_202208;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @author: fanghao
 * @create: 2022/8/19
 **/
public class Offer_28spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0) return new int[0];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        int[] result = new int[numEle];
        int index = 0;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++){
                result[index++] = matrix[top][i];
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++){
                result[index++] = matrix[i][right];
                numEle--;
            }
            right--;

            for (int i = right; i >= left && numEle >= 1; i--){
                result[index++] = matrix[bottom][i];
                numEle--;
            }
            bottom--;

            for (int i = bottom; i >= top && numEle >= 1; i--){
                result[index++] = matrix[i][left];
                numEle--;
            }
            left++;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Offer_28spiralOrder solution = new Offer_28spiralOrder();
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }
}
