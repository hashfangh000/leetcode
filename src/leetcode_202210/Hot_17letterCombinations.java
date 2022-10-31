package leetcode_202210;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/31
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 回溯法，先定位数字，再定位数字所代表的字母
 *
 **/
public class Hot_17letterCombinations {
    String[] str = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0){
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
        char c = digits.charAt(index);
        int pos = c - '0';
        String curdigit = str[pos];
        for (int i = 0; i < curdigit.length(); i++){
            cur.append(curdigit.charAt(i));
            backtrack(digits, cur, index + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
