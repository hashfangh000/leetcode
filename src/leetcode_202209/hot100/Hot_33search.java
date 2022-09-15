package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @author: fanghao
 * @create: 2022/9/15
 * 将数组一分为2， 一个有序， 另一个部分有序，若target>=nums[0]，
 **/
public class Hot_33search {
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //判断target在左半段还是右半段
            if (nums[mid] >= nums[l]){
                if (target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if (target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 1));
    }
}
