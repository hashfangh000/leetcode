package leetcode_202211;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: https://leetcode.cn/problems/decode-string/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/21
 *
 * 字符串解码
 * s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 **/
public class Hot_394decodeString {
    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer();
        char[] chars = s.toCharArray();
        Deque<StringBuffer> letter = new LinkedList<>();
        Deque<Integer> number = new LinkedList<>();
        int multi = 0;
        for(int i = 0; i < chars.length; ++i){
            char ch = chars[i];
            if(Character.isDigit(ch)){
                multi = multi * 10 + ch - '0';
            }else if(ch == '['){
                letter.push(ans);
                number.push(multi);
                ans = new StringBuffer();
                multi = 0;

            }else if(Character.isAlphabetic(ch)){
                ans.append(ch);
            }else {
                StringBuffer ansTmp = letter.pop();
                int tmp = number.pop();
                for (int j = 0; j < tmp; ++j){
                    ansTmp.append(ans);
                }
                ans = ansTmp;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
}
