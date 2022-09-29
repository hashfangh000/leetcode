package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/word-search/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/29
 * check(i, j)表示从网格(i, j) 位置出发，能否搜索到单词word[k...]， word[k...]表示单词work从k位置开始的后缀字串
 * 设置函数check(i ,j ,k)，
 * 如果board[i][j] != word[k], return false
 * 如果能访问到word的末尾，则能匹配，
 * 否则，遍历当前位置的相邻位置，，如果从某个相邻位置出发，能匹配到字串word[k+1...]，则return true， 否则 return false
 * 对于每个board的元素，都判断一次check(i ,j, k),
 **/
public class Hot_79exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean ans = check(board, visit, i, j, word, 0);
                if (ans){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visit, int i, int j, String str, int k) {
        if (board[i][j] != str.charAt(k)){
            return false;
        }else if(k == str.length() - 1){
            return true;
        }
        //右， 左，下，上
        int[][] directions =  {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visit[i][j] = true;                             // i, j 开始位置标记为true
        boolean res = false;
        for (int[] dir: directions){                    //四个不同方向，
            int newi = i + dir[0], newj = j + dir[1];
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if (!visit[newi][newj]){
                    boolean flag = check(board, visit, newi, newj, str, k + 1);
                    if (flag){
                        res = true;
                        break;
                    }
                }
            }
        }
        //回溯
        visit[i][j] = false;
        return res;
    }
}
