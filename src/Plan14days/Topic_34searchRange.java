package Plan14days;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author fanghao on 2022/2/22
 */
public class Topic_34searchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid;
                right = mid;
                while (right <= len - 1 && nums[right] == target){
                    right++;
                }
                while (left >= 0 && nums[left] == target){
                    left--;
                }
                return new int[]{left + 1, right - 1};
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Topic_34searchRange solution = new Topic_34searchRange();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution.searchRange(nums, 8)));
    }
}