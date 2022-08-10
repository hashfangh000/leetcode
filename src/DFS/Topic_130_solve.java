package DFS;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 没弄懂
 *
 */
public class Topic_130_solve {
    int col, row;
    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        if (col == 0){
            return;
        }
        //从边界开始遍历O
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                boolean isedge = i == 0 || j == 0 || i == row - 1 || j == col - 1;
                if (isedge && board[i][j] == 'O'){
                    DFS(board, i, j);
                }
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    //DFS查找board[x][y]=='0'的位置并将其标记为'A'
    //再次检查board，将标记为'A'的替换成'0'，没有标记的用'x'填充
    private void DFS(char[][] board, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        DFS(board, x - 1, y);
        DFS(board, x + 1, y);
        DFS(board, x, y - 1);
        DFS(board, x, y + 1);
    }
}
