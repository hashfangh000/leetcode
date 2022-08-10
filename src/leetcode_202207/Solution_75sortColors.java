package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/sort-colors/
 * @author: fanghao
 * @create: 2022-07-06 14:11
 **/

public class Solution_75sortColors {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int left = -1, right = r + 1;
        while(l < right){
            if(nums[l] > 1){
                swap(nums, --right, l);
            }else if(nums[l] < 1){
                swap(nums, ++left, l++);
            }else{
                l++;
            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
