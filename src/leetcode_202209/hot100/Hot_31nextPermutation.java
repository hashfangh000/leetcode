package leetcode_202209.hot100;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @description: https://leetcode.cn/problems/next-permutation/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/14
 *
 *
 * 找出比nums中刚好大的数
 * nums ： 1, 2, 3, 4   ans: 1, 2, 4, 3
 * 要求原地交换
 *
 * 从后往前找
 * 1、第一趟找出nums[i] < nums[i + 1]的数，那么nums[i + 1...len - 1]都是降序，nums[i] 为可以交换的数，跟谁交换
 * 2、第二趟找出比nums[i] 大的数，将其交换
 * 3、将i + 1～len - 1 的数字反转，即为刚好大的数
 * 例：4,5,1,6,3,2    ans ： 4,5,2,1,3,6
 *  第一趟找到 1
 *  第二趟找到 2
 *  交换      4,5,2,6,3,1
 *  i + 1反转 4,5,2,1,3,6
 **/
public class Hot_31nextPermutation {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void nextPermutation(int[] nums) {
        int l = 0;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
