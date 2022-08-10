package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 查找排序数组中 一个数出现的次数
 * @author: fanghao
 * @create: 2022-07-30 10:07
 **/

public class Solution_53search {
    public int search(int[] nums, int target) {
        //flag为true查找第一个大于等于target的值，为false查找第一个大于target的值
        int leftindex = binarySearch(nums, target, true);
        int rightindex = binarySearch(nums, target, false) - 1;
        if (leftindex <= rightindex && rightindex < nums.length && nums[leftindex] == target && nums[rightindex] == target) {
            return rightindex - leftindex + 1;
        }
        return 0;

    }

    private int binarySearch(int[] nums, int target, boolean flag) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (flag && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_53search solution = new Solution_53search();
        int[] nums = {3,3,3,6,9,15,23};
        System.out.println(solution.binarySearch(nums, 3,true));
    }
}
