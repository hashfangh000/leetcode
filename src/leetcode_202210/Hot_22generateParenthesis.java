package leetcode_202210;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/generate-parentheses/
 * @author: fanghao
 * @create: 2022/10/31
 **/
public class Hot_22generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuffer(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuffer current, int left, int right, int max) {
        if (current.length() == max * 2){
            ans.add(current.toString());
            return;
        }
        if(left < max){                                                 //左括号数量小于n时，加一个左括号
            current.append('(');
            backtrack(ans, current, left + 1, right, max);
            current.deleteCharAt(current.length() - 1);
        }
        if (right < left){                                              //右括号数量小于左括号时，加一个右括号
            current.append(")");
            backtrack(ans, current, left, right + 1, max);
            current.deleteCharAt(current.length() - 1);                 //回溯
        }
    }
}
