package Backtrack;



/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class Topic_52_totalNQueens {
    public int totalNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                chars[i][j] = '.';
            }
        }
        int  ans = backtracking(chars, 0, n);
        return ans;
    }

    private int backtracking(char[][] chars, int row, int n) {
        if (row == n){
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++){
            if (isValid(chars, row, col)){
                chars[row][col] = 'Q';
                count += backtracking(chars, row + 1, n);
                chars[row][col] = '.';
            }
        }
        return count;
    }
    //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
    private boolean isValid(char[][] chars, int row, int col) {
        for (int i = 0; i <= row; i ++){
            for (int j = 0; j < chars[0].length; j++){
                if (chars[i][j] == 'Q' && (j == col || Math.abs(row - i) == Math.abs(col - j))){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Topic_52_totalNQueens solution = new Topic_52_totalNQueens();

        System.out.println(solution.totalNQueens(4));
    }
}
