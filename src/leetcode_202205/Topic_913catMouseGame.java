package leetcode_202205;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/cat-and-mouse/
 *
 * @author fanghao on 2022/5/10
 */
public class Topic_913catMouseGame {
    static final int MOUSE_WIN = 1;
    static final int CAT_WIN = 2;
    static final int DRAW = 0;
    int n;
    int[][] graph;
    int[][][] dp;
    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.dp = new int[n][n][2 * n * (n - 1)];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(1, 2, 0);
    }

    private int getResult(int mouse, int cat, int turns) {
        if (turns == 2 * n * (n - 1)){
            return DRAW;
        }
        if (dp[mouse][cat][turns] < 0){
            if (mouse == 0){
                dp[mouse][cat][turns] = MOUSE_WIN;
            }else if(cat == mouse){
                dp[mouse][cat][turns] = CAT_WIN;
            }else{
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    private void getNextResult(int mouse, int cat, int turns) {
        int curMove = turns % 2 == 0 ? mouse : cat;
        int defultResult =  curMove == mouse ? CAT_WIN : MOUSE_WIN;
        int result = defultResult;
        int[] nextNodes = graph[curMove];
        for (int nextNode : nextNodes) {
            if (curMove == cat && nextNode == 0){
                continue;
            }
            int nextMouse = curMove == mouse ? nextNode : mouse;
            int nextCat = curMove == cat ? nextMouse : cat;
            int nextResult = getResult(nextMouse, nextCat, turns + 1);
            if (nextResult != defultResult){
                result = nextResult;
                //有胜者
                if (result != DRAW){
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }
}