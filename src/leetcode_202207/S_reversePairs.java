package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @author: fanghao
 * @create: 2022-07-22 19:31
 **/

public class S_reversePairs {
    public int reversePairs(int[] nums) {
        if(nums.length < 2 || nums == null){
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }
    public int process(int[] nums, int l, int r){
        if(l == r){
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) + process(nums, mid + 1, r) + merge(nums, l, mid, r);
    }

    private int merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = help.length - 1;
        int p1 = mid;
        int p2 = r;
        int res = 0;
        while (p1 >= l && p2 > mid){
            res += nums[p1] > nums[p2] ? (p2 - mid) : 0;
            help[i--] = nums[p1] > nums[p2] ? nums[p1--] : nums[p2--];
        }
        while (p1 >= l){
            help[i--] = nums[p1--];
        }
        while (p2 > mid){
            help[i--] = nums[p2--];
        }
        for (i = 0; i < help.length; i++){
            nums[l + i] = help[i];
        }
        return res;
    }
}
