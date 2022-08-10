package Plan14days;

/**
 * 动态规划——最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author fanghao on 2022/3/7
 *
 */
public class Topic_5longestPalindrome {
    //动态规划法  记录最大长度子串的长度和起始位置 再截取
    //时间复杂度 O(n2)
    //空间复杂度 O(n2)
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        //公式：p[i,j]是回文的话 p[i+1,j-1]也是回文
        //有 p[i,j] = p[i+1,j-1] && s[i] == s[j]
        boolean[][] dp = new boolean[len][len];
        /**
         * s[i,i]作为只有一个元素 肯定是回文，设为true
         */
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        int maxlen = 1;         //最长回文初始值设为1
        int begin = 0;
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if (j - i < 3){     //j - i <= 2   i 和 j之间就一个字母
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] == true && j - i + 1 > maxlen){
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

    public static void main(String[] args) {
        Topic_5longestPalindrome solution = new Topic_5longestPalindrome();
        System.out.println(solution.longestPalindrome("babdadb"));
    }
}
