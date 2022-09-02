package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/container-with-most-water/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/1
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器
 *
 *  双指针，i = 0, j = len - 1
 *  当前area = Math.min(height[i], height[j]) * (j - i);
 *  取 area 和 res 最大面积
 *  如果左边的height 小于 右边，左边向右移一个位置，
 **/
public class Hot_11maxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while(i < j){           //O(n)
            int area = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(area, res);
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
