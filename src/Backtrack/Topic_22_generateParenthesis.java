package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 时间复杂度：O(4^n / 根号(n))
 * 空间复杂度：O(n)
 */
public class Topic_22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuffer(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuffer current, int left, int right, int max) {
        if (current.length() == max * 2){
            ans.add(current.toString());
            return;
        }
        if (left < max){                                                   // 左括号 小于n时  加一个左括号
            current.append("(");
            backtrack(ans, current, left + 1, right, max);
            current.deleteCharAt(current.length() - 1);                 //回溯 向上走 要注意理解
        }
        if (right < left){                                              //右括号数量小于左括号时，加一个右括号
            current.append(")");
            backtrack(ans, current, left, right + 1, max);
            current.deleteCharAt(current.length() - 1);                 //回溯
        }
    }

//    private void backtrack(int left, int right, List<String> ans, String current) {
//        if (left == 0 && right == 0){
//            ans.add(current);
//            return;
//        }
//        if (left > 0){
//            backtrack(left - 1, right, ans, current + "(");
//        }
//        if (left < right){
//            backtrack(left, right - 1, ans, current + ")");
//        }
//    }

    public static void main(String[] args) {
        Topic_22_generateParenthesis solution = new Topic_22_generateParenthesis();
        List<String> ans = solution.generateParenthesis(3);
        for (String an : ans) {
            System.out.println(an);
        }
    }


}
