package Plan14days;

import Backtrack.Topic_79_exist;

/**
 * https://leetcode-cn.com/problems/word-search/
 *
 * @author fanghao on 2022/3/9
 */
public class Topic_79exist {
    public boolean exist(char[][] board, String word) {
        int col = board.length;
        int row = board[0].length;
        boolean[][] visit = new boolean[col][row];

        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                boolean ans = backtracking(board, visit, word, i ,j, 0);
                if (ans){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, boolean[][] visit, String str, int i, int j, int k) {
        if (board[i][j] != str.charAt(k)){      //当前字符不匹配 返回false 不一定是最终结果
            return false;
        }else if(str.length() - 1 == k){         //匹配到字符末尾时，且都相等 返回true
            return true;
        }
        visit[i][j] = true; //判断以后 标记为已访问
        //设置上下左右四个方向
        int[][] direnctions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean ans = false;
        for (int[] direnction : direnctions) {
            int newi = i + direnction[0], newj = j + direnction[1];
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if (!visit[newi][newj]){
                    boolean flag = backtracking(board, visit, str, newi, newj, k + 1);
                    if (flag){
                        ans = true;
                        break;
                    }
                }
            }
        }
        visit[i][j] = false;
        return ans;
    }

    public static void main(String[] args) {
        Topic_79_exist solution = new Topic_79_exist();
        boolean ans = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE");
        System.out.println(ans);
    }
}