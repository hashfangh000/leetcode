package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/trapping-rain-water/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/3
 *
 *
 **/
public class Hot_42trap {
    public int trap(int[] height) {
        //对于i位置能接到的雨水，是由i位置左右的高度的最小值决定，min(rightMax[i] , leftMax[i]) - height[i]
        int len = height.length;
        int[] leftMax = new int[len];   //从第一个位置开始的最大高度
        int[] rightMax = new int[len];  //从倒数第二个位置开始的最大高度
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for(int i = 1; i < len; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for(int i = len - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int water = 0;
        for(int i = 0; i < len; i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
