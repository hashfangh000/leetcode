package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/longest-palindromic-substring/
 * @author: fanghao
 * @create: 2022/8/31
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果dp[i][j]是回文， 那么dp[i + 1][j - 1] && s[i] == s[j]也是回文，
 **/
public class Hot_05longestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if (j - i <= 2){        // j 和 i之间就1个字符
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == true && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
