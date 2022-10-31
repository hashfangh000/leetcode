package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/longest-palindromic-substring/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/31
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果s[i..j]是回文串，s[i+1, j-1]也是回文
 * 如果s[i..j]是回文且s[i-1]==s[j + 1]，s[i-1...j+1]也是回文
 * 定义dp表示 s[i..j]是否为回文串
 **/
public class Hot_5longestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int begin = 0;                  //表示从begin开始的最长子串
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];     //dp[i][j]表示s[i..j]是否为回文串
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        //对于每一个结束的位置，都从0位置开始遍历，s[i...j]对于每一个结束位置j，i都从0开始遍历
        for(int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){          //aba
                        dp[i][j] = true;
                    }else{                  //cabac
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == true && j - i + 1 > maxLen){
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
