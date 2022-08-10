package leetcode_202207;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/shift-2d-grid/
 * @author: fanghao
 * @create: 2022-07-20 11:19
 **/

public class Solution_1260shiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int m = grid.length,n = grid[0].length;
        for (int i = 0; i < m; i++){
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++){
                row.add(0);
            }
            ans.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index1 = (i * n + j + k) % (m * n);
                ans.get(index1 / n).set(index1 % n, grid[i][j]);
            }
        }
        return ans;
    }

}
