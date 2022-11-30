package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/container-with-most-water/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/26
 * 盛水最多的容器
 *
 * 存在两指针i, j 对应木板高度为height[i], height[j]
 * 面积为 min(height[i], height[j]) * (j - i), 由最小的木板决定
 * 如果向内移动短板，短板可能会遇到长板，面积可能会增大
 * 若向内移动长板，面积不变或变小
 * 移动一格，两板之间都会变窄一格
 * 定义双指针，分别位于左右，如果height[i]  < height[j] 说明i可以向内移动为长板，可能增大
 * 反之，j向内移动一格可能会遇到长板，也可能增大
 * 如果两指针相遇，退出
 **/
public class Hot_11maxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxarea = 0;
        while(i < j){
            int area = Math.min(height[i], height[j]) * (j - i);
            maxarea = Math.max(area, maxarea);
            if(height[i] < height[j]){          //i可能会成为长板
                i++;
            }else{                              //j可能会成为长板
                j--;
            }
        }
        return maxarea;
    }
}
