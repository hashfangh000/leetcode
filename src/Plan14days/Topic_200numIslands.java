package Plan14days;

/**
 * https://leetcode-cn.com/problems/number-of-islands/submissions/
 */

public class Topic_200numIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;      //行
        int col = grid[0].length;   //列
        if (grid == null || row == 0){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
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
        /**
         * i < 0 和 j < 0 控制左和上边界
         * i >= row || j >= col  控制下边界和右边界
         * grid[i][j] == '0' 遇到水 就停止
         */
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0'){
            return;
        }
        //把遍历过的岛屿 换成水 再根据上面判断条件 做递归出口 遍历过的不再遍历
        grid[i][j] = '0';
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);
        DFS(grid, i, j - 1);
        DFS(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1'},
                {'0', '1','0'},
                {'0', '0', '1'}};
        Topic_200numIslands solution = new Topic_200numIslands();
        System.out.println(solution.numIslands(grid));
    }
}
