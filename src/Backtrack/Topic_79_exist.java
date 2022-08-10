package Backtrack;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class Topic_79_exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean ans = backtracking(board, visit, i, j, word, 0);
                if (ans){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, boolean[][] visit, int i, int j, String str, int k) {
        if (board[i][j] != str.charAt(k)){
            return false;
        }else if(k == str.length() - 1){
            return true;
        }
        visit[i][j] = true;
        int[][] directions =  {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] dir : directions){
            int newi = i + dir[0], newj = j +  dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visit[newi][newj]) {
                    boolean flag = backtracking(board, visit, newi, newj, str, k + 1);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visit[i][j] = false;
        return res;
    }
    public static void main(String[] args) {
        Topic_79_exist solution = new Topic_79_exist();
        boolean ans = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE");
        System.out.println(ans);
    }
}
