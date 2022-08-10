package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class Topic_51_solveNQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                chars[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        backtracking(chars, 0, n, ans);
        return ans;
    }

    private void backtracking(char[][] chars, int row, int n, List<List<String>> ans) {
        if (row == n){
            ans.add(charsToList(chars));
            return;
        }
        for (int col = 0; col < n; col++){
            if (isValid(chars, row, col)){
                chars[row][col] = 'Q';
                backtracking(chars, row + 1, n, ans);
                chars[row][col] = '.';
            }
        }
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

    private List<String> charsToList(char[][] chars) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++){
            list.add(new String(chars[i]));
        }
        return list;
    }

    public static void main(String[] args) {
        Topic_51_solveNQueens solution = new Topic_51_solveNQueens();
        List<List<String>> ans = solution.solveNQueens(4);
        for (List<String> an : ans) {
            for (String integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}
