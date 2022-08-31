package leetcode_202209.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/8/31
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 定义maxLen = 起始位置为i 结束位置为j的最长不重复字串的长度，对于每个i 都有一个最长长度，取最大长度。
 **/
public class Hot_03lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, rk = -1;    //rk表示右指针
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){       //O(n)

            if (i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))){  //O(n)
                set.add(s.charAt(rk + 1));
                rk++;
            }
            maxLen = Math.max(rk - i + 1, maxLen);
        }   //O(n)
        return maxLen;
    }
}
