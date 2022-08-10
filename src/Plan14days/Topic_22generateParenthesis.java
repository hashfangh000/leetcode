package Plan14days;

import Backtrack.Topic_22_generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Topic_22generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        backtrack(n, ans, 0, 0, new StringBuffer());
        return ans;
    }

    private void backtrack(int n, List<String> ans, int left, int right, StringBuffer stringBuffer) {
        if (stringBuffer.length() == n * 2){
            ans.add(stringBuffer.toString());
            return;
        }
        if (left < n){
            stringBuffer.append("(");
            backtrack(n, ans, left + 1, right, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (right < left){
            stringBuffer.append(")");
            backtrack(n, ans, left, right + 1, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }


    public static void main(String[] args) {
        Topic_22generateParenthesis solution = new Topic_22generateParenthesis();
        List<String> ans = solution.generateParenthesis(3);
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
