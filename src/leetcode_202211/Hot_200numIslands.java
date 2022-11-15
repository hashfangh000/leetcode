package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/number-of-islands/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/15
 * 计算网格中岛屿第数量, 对于每一个位置grid[i][j] 如果为1，则继续DFS其相邻位置是否有1，并将1换成0，将陆地换成水
 * DFS()判断如果遇到水 就return;， 然后在继续DFS i, j 上下左右四个位置上是否有1
 **/
public class Hot_200numIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;      //行
        int col = grid[0].length;   //列
        if (grid == null || row == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                if (grid[i][j] == '1'){
                    ans++;
                    DFS(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void DFS(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);
        DFS(grid, i, j - 1);
        DFS(grid, i, j + 1);
    }
}
