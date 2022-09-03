package leetcode_202209.hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022-09-03 20:48
 *
 * 电话号码的字母组合 回溯
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 *
 **/

public class Hot_17letterCombinations {
    List<String> ans = new ArrayList<>();
    // strings 下标对应键盘上的数字
    String[] strings = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == ""){
            return ans;
        }
        backtrack(digits, new StringBuffer(), 0);
        return ans;
    }

    private void backtrack(String digits, StringBuffer cur, int index) {
        if(index == digits.length()){
            ans.add(cur.toString());
            return;
        }
        char c = digits.charAt(index);      //每一个数字
        int pos = c - '0';
        String curDigit = strings[pos];
        for (int i = 0; i < curDigit.length(); i++){        //当前数字对应的字母
            cur.append(curDigit.charAt(i));
            backtrack(digits, cur, index + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
