package leetcode_202208;

import Backtrack.Topic_79_exist;

public class Offer_12exist {
    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0;j < board[0].length; ++j){
                if(DFS(board,str,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private  boolean DFS(char[][] board, char[] word, int i, int j, int k) {
        //四个方向 i不能超过row j不能超过col
        //或者不匹配时
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]){
            return false;
        }
        //不满足以上条件时 若匹配的长度和word长度一样 则搜索完毕 返回true
        if (k == word.length - 1){
            return true;
        }
//        char temp = board[i][j];
//        board[i][j] = '/';
//        /**
//         * 四个方向
//         */
//        int[] dx = new int[]{-1,0,1,0};
//        int[] dy = new int[]{0,1,0,-1};
//
//        for(int q = 0;q < 4; ++q){
//            int m = i + dx[q];
//            int n = j + dy[q];
//            if(DFS(board,word,m,n,k + 1)){
//                return true;
//            }
//        }
//        board[i][j] = temp;
//
//        return false;
        board[i][j] = '\0';
        boolean res = DFS(board, word, i + 1, j, k + 1) || DFS(board, word, i - 1, j, k + 1)
                || DFS(board, word, i, j - 1, k + 1) || DFS(board, word, i, j + 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    public static void main(String[] args) {
        Offer_12exist solution = new Offer_12exist();

        boolean ans = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE");
        System.out.println(ans);

    }
}
