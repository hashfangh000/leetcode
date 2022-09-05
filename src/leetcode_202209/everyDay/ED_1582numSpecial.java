package leetcode_202209.everyDay;

/**
 * @description: https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
 * @author: fanghao
 * @create: 2022/9/4
 **/
public class ED_1582numSpecial {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowsSum = new int[m];
        int[] colsSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowsSum[i] += mat[i][j];            //每一行1的个数
                colsSum[j] += mat[i][j];            //每一列1的个数
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowsSum[i] == 1 && colsSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
