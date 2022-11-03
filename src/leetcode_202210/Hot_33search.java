package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/search-in-rotated-sorted-array/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/2
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1.
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 数组从某个位置开始到数组末尾是升序，用二分查找，将数组一分为二，一个是有序，另一个是部分有序
 * 对于nums[0]和target的关系判断目标值在左半段还是右半段
 **/
public class Hot_33search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = n - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            //如果0...mid是升序
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){       //判断target是不是在0...mid的区间内，在的话缩小区间
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else{                                                  //0...mid不是升序的话，剩下的就是升序，
                if(nums[mid] < target && target <= nums[n - 1]){    //target在mid...n-1区间内的话，缩小区间
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
