package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/trapping-rain-water/
 * @author: fanghao
 * @create: 2022/9/19
 *
 * 对于i位置雨水的最大高度，取决与i位置两边的最低高度
 * i位置的最大雨水量，等于i位置雨水的最大高度-height[i]
 * 定义两个数组，leftMax, rightMax,
 * leftMax 是从第1个位置开始的最大高度
 * rightMax 是倒数第二个位置开始 往左遍历的最大高度，
 * 然后 min(rightMax[i] , leftMax[i]) - height[i] 即为当前i所能盛雨水的最大量
 * 想加即可
 **/
public class Hot_42trap {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < size - 1; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
