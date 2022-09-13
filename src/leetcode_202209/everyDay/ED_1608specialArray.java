package leetcode_202209.everyDay;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 * @author: fanghao
 * @create: 2022/9/12
 **/
public class ED_1608specialArray {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0] >= nums.length){
            return n;
        }
        int res = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] >= (res = n - i) && nums[i - 1] < res) {
                return res;
            }
        }
        return -1;
    }
}
