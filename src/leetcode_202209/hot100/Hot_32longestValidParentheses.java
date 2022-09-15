package leetcode_202209.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/longest-valid-parentheses/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/15
 **/
public class Hot_32longestValidParentheses {
    public static int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
}
