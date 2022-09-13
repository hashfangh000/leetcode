package leetcode_202209.everyDay;

import java.util.Map;

/**
 * @description: https://leetcode.cn/problems/maximum-swap/
 * @author: fanghao
 * @create: 2022/9/13
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 2736 -> 7236, 交换一次
 *
 * 数字范围[0, 10^8]
 *
 *
 **/
public class ED_670maximumSwap {
    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int len = charArray.length;
        int maxNum = num;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++ ){
                swap(charArray, i , j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap(charArray, i , j);
            }
        }
        return maxNum;
    }
}
