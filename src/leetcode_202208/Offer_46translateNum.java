package leetcode_202208;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @author: fanghao
 * @create: 2022-08-04 13:47
 **/

public class Offer_46translateNum {
    public int translateNum(int num) {
        /*String s = String.valueOf(num);
        int len = s.length();
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len; i >= 1; i--){
            for (int j = i; j <= len; j++){
                if (i == j){
                    dp[i][j] = 1;
                }else{

                    int check = ((s.charAt(j - 2) - '0') * 10 + s.charAt(j - 1) - '0') > 25 ? 0 : 1;

                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]) + check;
                }
            }
        }
        return dp[1][len];*/
        /*String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;*/
        char[] ch = String.valueOf(num).toCharArray();
        int len = ch.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++){
            int check = ((ch[i - 2] - '0') * 10 + ch[i - 1] - '0');
            if (check >= 10 && check <= 25){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Offer_46translateNum s = new Offer_46translateNum();
        s.translateNum(624);
    }
}
