package leetcode_202209.everyDay;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description: https://leetcode.cn/problems/maximum-length-of-pair-chain/
 * @author: fanghao
 * @create: 2022-09-03 20:21
 **/

public class ED_646findLongestChain {
    public int findLongestChain(int[][] pairs) {
        //按照数对中第二个数进行排序，再从第一开始判断
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 1;
        int tmp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++){     //O(n)
            if (pairs[i][0] > tmp){
                res++;
                tmp = pairs[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,5},{2,3},{3,6},{4,5}};
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
