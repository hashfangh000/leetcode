package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/palindromic-substrings/
 * @author: fanghao
 * @create: 2022/11/24
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串
 * 中心扩散法找回文字串，
 **/
public class Hot_647countSubstrings {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i){
            int l = i / 2, r = i / 2 + i % 2;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
