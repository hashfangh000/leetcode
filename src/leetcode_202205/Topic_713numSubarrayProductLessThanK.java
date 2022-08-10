package leetcode_202205;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 滑动窗口
 */
public class Topic_713numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        if(k <= 1){
            return res;
        }
        int product = 1, left = 0;
        for (int right = 0; right < nums.length; right++){
            product *= nums[right];
            while (product >= k){
                product /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Topic_713numSubarrayProductLessThanK solution = new Topic_713numSubarrayProductLessThanK();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
