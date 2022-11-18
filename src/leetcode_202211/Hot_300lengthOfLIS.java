package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/longest-increasing-subsequence/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/18
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 动态规划：dp[i] 表示 i结尾的最长递增子序列的长度 ，
 * dp[i - 1] 表示[0...i - 1] 的最长递增子序列 ，对于nums[i] 能不能让其加入进去之后 序列长度有所增加，这时要考虑[0...i - 1]这个范围内有没有j结尾的序列 nums[j] < nums[i]的情况
 * 如 4, 10, 4, 3, 8, 9
 *    1, 2, 1, 1, 2, 对于9,我们找9前面的最大递增子序列，有比9小的，取+1后的最大值
 **/
public class Hot_300lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < n; ++i){
            dp[i] = 1;                      //每一个位置都可以是一个子序列 为1
            for(int j = 0; j < i; ++j){
                if (nums[i] > nums[j]){     //在区间[0...i - 1]有比nums[i]小的数nums[j]，就可以在这个序列后面加上nums[i]，取最大长度(dp[j]+1, dp[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);

        }
        return ans;
    }
}
