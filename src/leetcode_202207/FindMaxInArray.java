package leetcode_202207;

/**
 * @program: leetcode_202207
 * @description: 查找数组中的最大值,
 * @author: fanghao
 * @create: 2022/7/2 17:46
 * test
 */
public class FindMaxInArray {
    public int findMax(int[] nums){
        int len = nums.length;
        return process(nums, 0, len - 1);
    }
    private int process(int[] nums, int l, int r){
        if (l == r){
            return nums[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftmax = process(nums, l, mid);
        int rightmax = process(nums, mid + 1, r);
        return leftmax > rightmax ? leftmax : rightmax;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,3,4,5,7,4,3};
        FindMaxInArray solution = new FindMaxInArray();
        int max = solution.findMax(nums);
        System.out.println(max);
    }
}