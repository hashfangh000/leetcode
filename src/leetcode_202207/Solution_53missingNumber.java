package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 * @author: fanghao
 * @create: 2022-07-30 10:35
 **/

public class Solution_53missingNumber {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //不存在nums[mid] < mid
            if(nums[mid] > mid){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
