package leetcode_202206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/diagonal-traverse/
 * @author: fanghao
 * @create: 2022-06-14 16:40
 **/

public class Topic_498findDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++){
            if (i % 2 == 1){    //左下
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0){
                    ans[pos] = mat[x][y];
                    pos++;
                    x++;y--;
                }
            }else{
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n){
                    ans[pos] = mat[x][y];
                    pos++;
                    x--;y++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Topic_498findDiagonalOrder solution = new Topic_498findDiagonalOrder();
        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{1,2,3}, {4,5,6},{7,8,9}})));
        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{1,2}, {3,4}})));
        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{1,2,3,4}, {5,6,7,8},{9, 10, 11, 12}, {13, 14, 15, 16}})));
    }
}
