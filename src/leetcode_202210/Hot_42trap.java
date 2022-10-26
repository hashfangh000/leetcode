package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/trapping-rain-water/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/26
 * 对于i位置雨水的最大高度，取决与i位置两边的最低高度
 * i位置的最大雨水量，等于i位置雨水的最大高度-height[i]
 * 定义两个数组，leftMax, rightMax,
 * leftMax 是从第1个位置开始的最大高度
 * rightMax 是倒数第二个位置开始 往左遍历的最大高度，
 * 然后 min(rightMax[i] , leftMax[i]) - height[i] 即为当前i所能盛雨水的最大量
 * 相加即可
 **/
public class Hot_42trap {
    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++){                                //比较从左往右，当前是i，比较i - 1 和 hejght[i]的大小
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--){                           //比较从右往左，当前是i，比较i + 1 和height[i]的大小
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < n; i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
}
