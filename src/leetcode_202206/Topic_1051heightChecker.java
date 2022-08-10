package leetcode_202206;

import java.util.Arrays;

/**
 * @program: leetcode_202206
 * @description: https://leetcode.cn/problems/height-checker/
 * @author: fanghao
 * @create: 2022/6/13 10:09
 */
public class Topic_1051heightChecker {
    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] sort_heights = Arrays.copyOf(heights, len);
        Arrays.sort(sort_heights);
        int ans = 0;
        for(int i = 0; i < len; i++){
            if(heights[i] != sort_heights[i]){
                ans ++;
            }
        }
        return ans;
    }
}