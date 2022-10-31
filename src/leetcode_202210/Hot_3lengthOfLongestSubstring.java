package leetcode_202210;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/31
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 用set存储当前不重复的最长字串，接着指针r不断向右遍历，if !set.contains(r + 1) : set.add(r + 1)
 *
 * 对于每一个起始位置i,都有一个最大长度，每次遍历i,将i-1位置从set中move掉
 * 总共复杂度为O(n) 因为左指针和右指针分别会遍历整个字符串1次
 **/
public class Hot_3lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int r = -1;
        int maxLen = 0, len = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(r + 1 < len && !set.contains(s.charAt(r + 1))){
                set.add(s.charAt(r + 1));
                r++;
            }
            maxLen = Math.max(maxLen, r - i + 1);
        }
        return maxLen;
    }
}
