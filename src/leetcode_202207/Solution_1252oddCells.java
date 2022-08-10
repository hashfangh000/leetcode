package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 * @author: fanghao
 * @create: 2022-07-12 10:08
 **/

public class Solution_1252oddCells {
    public int oddCells(int m, int n, int[][] indices) {
        /*int[][] arr = new int[m][n];
        for(int[] indice : indices){
            for (int i = 0; i < n; i++){
                arr[indice[0]][i]++;
            }
            for (int j = 0; j < m ;j++){
                arr[j][indice[1]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] % 2 == 1){
                    res++;
                }
            }
        }
        return res;*/

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
