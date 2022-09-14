package leetcode_202209.everyDay;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 * @author: fanghao
 * @create: 2022/9/14
 **/
public class ED_1619trimMean {
    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int l = len / 20;
        double sum = 0;
        for (int i = l; i < len - l; i++){
            sum += arr[i];
        }
        return sum / (len - 2 * l);
    }

    public static void main(String[] args) {
        int[] arr = {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
        System.out.println(trimMean(arr));
    }
}
