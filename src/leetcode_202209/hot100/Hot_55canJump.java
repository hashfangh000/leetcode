package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/jump-game/
 * @author: fanghao
 * @create: 2022/9/23
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标
 *
 * 如果某一个起点i的位置为4，那么说明它可以跳到i后面的四个位置
 * 一个一个跳，能跳到最远距离不断更新；
 * 直到最后
 **/
public class Hot_55canJump {
    public boolean canJump(int[] nums) {
        int k = 0;      //从i起，能跳最远的距离
        int len = nums.length;
        for (int i = 0; i <= k; i++){
            k = Math.max(nums[i] + i, k);
            if (k >= len - 1){
                return true;
            }
        }
        return false;
    }
}
