package leetcode_202211;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/word-break/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/11
 **/
public class Hot_139wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        String[]  st= {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(st));
        System.out.println(wordBreak(s, wordDict));
    }
}
