package leetcode_202209.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/generate-parentheses/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/4
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 **/
public class Hot_22generateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        backtrack(ans, new StringBuffer(), 0, 0, n);
        return ans;
    }

    /**
     *
     * @param ans
     * @param cur
     * @param left      "(" 数量
     * @param right     ")" 数量
     * @param max       n
     */
    private void backtrack(List<String> ans, StringBuffer cur, int left, int right, int max) {
        if (cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }
        if(left < max){
            cur.append("(");
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left){                                              //右括号数量小于左括号时，加一个右括号
            cur.append(")");
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);                 //回溯
        }
    }
}
