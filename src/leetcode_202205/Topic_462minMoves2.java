package leetcode_202205;

import java.util.Arrays;

public class Topic_462minMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, res = 0, x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - x);
        }
        return res;
    }
}
