package Plan14days;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Topic_153findMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left - 1];
    }

    public static void main(String[] args) {
        Topic_153findMin solution = new Topic_153findMin();
        int[] nums = {3,4,5,1,2};
        System.out.println(solution.findMin(nums));
    }
}
