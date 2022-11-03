package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @author: fanghao
 * @create: 2022/11/2
 * 给你两个字符串haystack 和 needle ,
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果needle 不是 haystack 的一部分，则返回 -1 。
 *
 * 暴力枚举，
 **/
public class Topic_28strStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        for (int i = 0; i <= n - m; i++){
            int a = i, b = 0;
            while(b < m && s[a] == p[b]){
                a++;
                b++;
            }
            if (b == m){
                return i;
            }
        }
        return -1;
    }
}
