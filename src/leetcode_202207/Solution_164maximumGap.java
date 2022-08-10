package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/maximum-gap/
 * 排序好数组中相邻元素之间的最大间距
 * @author: fanghao
 * @create: 2022-07-21 20:43
 **/

public class Solution_164maximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        radixSort(nums, 0, nums.length - 1, maxbits(nums));
        int res = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 1; i--){
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
    private int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0){
            res++;
            max /= 10;
        }
        return res;
    }
    //arr[begin..end]排序，digit表示最大值有几个十进制位
    private void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        //有多少个数准备多少个辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++){       //有多少位就进出几次
            //10个空间
            //count[0] 当前位(d位)是0的数字有多少个
            //count[1] 当前位(d位)是0和1的数字有多少个
            //count[2] 当前位(d位)是0和1、2的数字有多少个
            //count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix];
            for (i = L; i <= R; i++){
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++){
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--){
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++){
                arr[i] = bucket[j];
            }
        }
    }
    private int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        Solution_164maximumGap solution = new Solution_164maximumGap();
        int[] nums = {3, 6, 1, 9};
        System.out.println(solution.maximumGap(nums));
    }
}
