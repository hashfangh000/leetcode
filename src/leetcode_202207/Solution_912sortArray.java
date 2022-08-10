package leetcode_202207;

/**
 * @program: leetcode_202207
 * @description: https://leetcode.cn/problems/sort-an-array/
 * @author: fanghao
 * @create: 2022/7/2 17:23
 * 归并排序
 */
public class Solution_912sortArray {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        process(nums, 0, len - 1);
        return nums;
    }
    private void process(int[] nums, int left, int right){
        if(left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(nums, left, mid);
        process(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(int[] nums, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        while(p1 <= mid && p2 <= right){
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1 <= mid){
            help[i++] = nums[p1++];
        }
        while(p2 <= right){
            help[i++] = nums[p2++];
        }
        for(i = 0; i < help.length; i++){
            nums[left + i] = help[i];
        }
    }
}