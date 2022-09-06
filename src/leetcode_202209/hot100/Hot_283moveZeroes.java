package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/move-zeroes/
 * @author: fanghao
 * @create: 2022/9/6
 **/
public class Hot_283moveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
