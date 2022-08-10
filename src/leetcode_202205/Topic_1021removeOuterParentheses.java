package leetcode_202205;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class Topic_1021removeOuterParentheses {

    public String removeOuterParentheses(String s) {
        StringBuffer ans = new StringBuffer();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                stack.pop();
            }
            if (!stack.isEmpty()){
                ans.append(c);
            }
            if(c == '('){
                stack.push(c);
            }
        }
        return ans.toString();
        /*int len = s.length();
        int left = 0, right = 0;
        int index = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) != '('){
                left++;
            }else{
                right++;
            }
            if (right == left){
                left = 0; right = 0;
                String str = s.substring(index + 1, i);
                index = i + 1;
                ans.append(str);
            }
        }
        return ans.toString();*/
    }

    public static void main(String[] args) {
        Topic_1021removeOuterParentheses solution = new Topic_1021removeOuterParentheses();
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(solution.removeOuterParentheses("()()"));
    }
}
