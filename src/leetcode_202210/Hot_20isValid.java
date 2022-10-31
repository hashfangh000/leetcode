package leetcode_202210;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/valid-parentheses/
 * @author: fanghao
 * @create: 2022/10/31
 *
 * 判断同类型的括号是否是左开右闭
 **/
public class Hot_20isValid {
    public static boolean isValid(String s) {
        if(s == null || s.equals("")){
            return false;
        }
        int len = s.length();
        if (len % 2 == 1){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.pop();

                if ((c != '(' && ch == ')') || (c != '{' && ch == '}') || (c != '[' && ch == ']')){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s = "(([])({}[]))";
        isValid(s);

    }
}
