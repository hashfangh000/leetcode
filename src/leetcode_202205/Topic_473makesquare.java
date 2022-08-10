package leetcode_202205;

import java.util.Arrays;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/matchsticks-to-square/
 * @author: fanghao
 * @create: 2022-06-01 15:36
 **/

public class Topic_473makesquare {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();;
//        for (int side : matchsticks) {
//            totalLen += side;
//        }
        if (totalLen % 4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] edges = new int[4];
        return DFS(0, matchsticks, edges, totalLen / 4);
    }

    private boolean DFS(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length){
            return true;
        }
        for (int i = 0; i < edges.length; i++){
            edges[i] += matchsticks[index];
            if (edges[i] <= len && DFS(index + 1, matchsticks, edges, len)){
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
