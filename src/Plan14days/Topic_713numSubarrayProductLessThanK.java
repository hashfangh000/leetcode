package Plan14days;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class Topic_713numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int ans = 0;
//
//        int len = nums.length;
//        for(int i = 0; i < len; i++){
//            long currentProduct = 1;
//            for (int j = 0; i + j < len; j++){
//                currentProduct = nums[i + j] * currentProduct;
//                if (currentProduct >= k){
//                    break;
//                }
//                ans++;
//
//            }
//        }
//        return ans;
        int ans = 0;
        if (k <= 1){
            return 0;
        }
        int product = 1, left = 0;
        for (int right = 0; right < nums.length; right++){
            product *= nums[right];
            while (product >= k){
                product /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Topic_713numSubarrayProductLessThanK solution = new Topic_713numSubarrayProductLessThanK();
        int[] nums = {10, 5, 2, 6};
        System.out.println(solution.numSubarrayProductLessThanK(nums, 100));
    }
}
