package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/16
 * 查找非递减顺序数组中 target的开始和结束位置
 * 如果没有就返回[-1, -1]
 * 复杂度O(long n)
 * 二分
 **/
public class Hot_34searchRange {
    public int[] searchRange(int[] nums, int target) {
        int right = nums.length - 1, left = 0;
        int len = nums.length;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){       //找到target位置，从该位置向两边扩
                left = mid;
                right = mid;
                while (right <= len - 1 && nums[right] == target) {
                    right++;
                }

                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                return new int[]{left + 1, right - 1};
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
