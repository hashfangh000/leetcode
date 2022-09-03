package leetcode_202209.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/valid-parentheses/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/3
 **/
public class Hot_20isValid {
    public boolean isValid(String s) {
        Deque<Character> stack=new LinkedList<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c == '('|| c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char topChar=stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
