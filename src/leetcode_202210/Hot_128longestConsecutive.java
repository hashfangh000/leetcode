package leetcode_202210;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: https://leetcode.cn/problems/longest-consecutive-sequence/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/29
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 *
 * nums = [100,4,200,1,3,2]
 *  4
 *
 * 首先排除重复的数字，对于当前数字num，看数组中有没有num - 1,如果没有，当前长度为1, 在看有没有num + 1，用while看看有没有num + 1，有的话更新当前长度和当前数 num = num + 1
 * 使用set集合去重，set.contains(num) 判断是否存在num
 *
 *
 **/
public class Hot_128longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)){            // 遇到 100， 没有 99 的话，当前长度为1
                int curNum = num;
                int curStreak = 1;

                while (set.contains(curNum + 1)){   //看看有没有101， 102， 103
                    curNum += 1;
                    curStreak += 1;
                }

                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }
}
