package Plan14days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author fanghao on 2022/2/23
 */
public class Topic_33search {
    public int search(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        int len = nums.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < len; i++){
//            map.put(nums[i], i);
//        }
//        Arrays.sort(nums);
//        while(left <= right){
//            int mid = left + (right - left) / 2;
//            if(nums[mid] == target){
//                return map.get(target);
//            }else if(nums[mid] > target){
//                right = mid - 1;
//            }else{
//                left = mid + 1;
//            }
//        }
//        return -1;
        int left = 0, right = nums.length - 1;
        int len = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= target){
                if (nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
            }else {
                if (nums[mid] >= nums[0]){
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}