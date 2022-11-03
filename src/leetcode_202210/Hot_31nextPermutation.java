package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/next-permutation/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/2
 *
 *
 * 整数数组中的下一个排列，例如[1, 2, 3] ->> [1, 3, 2]
 * 而对于[3, 2, 1]  ->> [1, 2, 3]
 * 又例如：[4, 5, 1, 6, 3, 2]  ->>  [4, 5, 2, 1, 6, 3], 需要用nums中点数调换后，比之前大一点点
 *  分两步：
 *  1.从后往前找到第一个满足nums[i] < nums[i + 1]的数，这个数就是要找的交换的第一个数，
 *  2.接着从后往前找第一个比nums[i]大的数，这个数就是要找的交换的第二个数
 *  注意这里的大于，而非大于等于。
 *  交换后将i + 1位置及其后面的数反转，就是要找的答案
 *  其中对于非增序排列的数组，也就是第一次找到的i = 0， 在while循环之后i的值为-1， 那么在第二次找的时候先判断i是否>=0， 小于0的话就不再找第二个数，
 *  继续将i+1位置及其后面反转
 **/
public class Hot_31nextPermutation {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start){
        int left = start, right = nums.length - 1;
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){       //第一个数
            i--;
        }
        if(i >= 0){
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i]){       //第二个数
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);                   //反转i + 1及其后面
    }
}
