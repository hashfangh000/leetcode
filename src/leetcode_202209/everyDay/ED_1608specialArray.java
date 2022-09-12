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
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= n; ++i) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }
}
