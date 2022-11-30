package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/regular-expression-matching/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/25
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *      所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串
 * s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次
 * 每次从p取一个字符或字符加*来匹配s 对于p中的一个字符 只能匹配s中的一个字符
 * 用dp[i][j]表示s的前i个字符与p中的前j个字符是否能够匹配，
 *  1.如果p的第j个字符是小写字母，必须在s中也找一个小写字母
 *      dp[i][j] = dp[i - 1][j - 1]  s[i] = s[j]
 *      dp[i][j] = false             s[i] != s[j]
 *  2.如果p的第j个字符是 * ，那么p的第j - 1个字符匹配任意自然数次
 *      在匹配0次时：dp[i][j] = dp[i][j - 2]
 *      有 dp[i][j] = dp[i][j - 2]                   s[i] != p[j - 1]
 *         dp[i][j] = dp[i - 1][j] || dp[i][j - 2]      s[i] = p[j - 1]
 *
 * 3. 在任意情况下，p[j]是 . 一定成功匹配s中的一个小写字母
 **/
public class Hot_10isMatch {
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i){

            for (int j = 1; j <= n; ++j){
                if(p.charAt(j - 1) == '*') {
                    //1.p[j-1]是*
                    dp[i][j] = dp[i][j - 2];   // * 前面的字符用0次
                    if(matches(s, p, i, j - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }else{
                    if(matches(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    //判断s的前i个 和p的前j个是否匹配
    //这里对应的下标为i - 1, j - 1
    private static boolean matches(String s, String p, int i, int j) {
        if(i == 0){
            return false;
        }
        if(p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {

        String s = "abcccccd";
        String p = "abc*d";
        isMatch(s, p);
    }
}
