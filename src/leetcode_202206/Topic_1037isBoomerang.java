package leetcode_202206;

import leetcode_202205.Topic_1021removeOuterParentheses;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/valid-boomerang/
 * @author: fanghao
 * @create: 2022-06-08 13:51
 **/

public class Topic_1037isBoomerang {
    public boolean isBoomerang(int[][] points) {
        if((points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) - (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) == 0){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        Topic_1037isBoomerang solution = new Topic_1037isBoomerang();
        System.out.println(solution.isBoomerang(new int[][]{{1,1}, {2,3}, {3,2}}));
        System.out.println(solution.isBoomerang(new int[][]{{0,0}, {0,2}, {2,1}}));

    }
}
