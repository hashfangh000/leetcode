package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/
 * @author: fanghao
 * @create: 2022/11/23
 * 定义maxn, minn表示待排序数组的右边界和左边界，从左往右找右边界，如果遇到比maxn大的，就说明现在是升序，将其赋值为maxn，继续往右找，否则定位一个right位置，
 * minn 从右往左找，遇到比我小的，说明是降序，赋值，但凡有一个比我大说明 序列不对，定位left
 **/
public class Hot_581findUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        int left = -1, right = -1;

        for (int i = 0; i < n; i++) {
            if(nums[i] < maxn){
                right = i;
            }else{
                maxn = nums[i];
            }
            if(nums[n - i - 1] > minn){
                left = n - i - 1;
            }else{
                minn = nums[n - i - 1];
            }

        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        findUnsortedSubarray(nums);
    }
}
