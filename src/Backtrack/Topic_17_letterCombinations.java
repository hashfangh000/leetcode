package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Topic_17_letterCombinations {
    List<String> ans = new ArrayList<>();
    String[] strings = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return ans;
        }
        backtrack(digits, new StringBuffer(), 0);
        return ans;
    }

    private void backtrack(String digits, StringBuffer stringBuffer, int index) {
        if (index == digits.length()){
            ans.add(stringBuffer.toString());
            return;
        }
        char c = digits.charAt(index);
        int pos = c - '0';
        String str = strings[pos];          //数字对应的字母
        for (int i = 0; i < str.length(); i++){
            stringBuffer.append(str.charAt(i));
            backtrack(digits, stringBuffer, index + 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);           //组合后 删除最后的一位 ae -> a  向上回溯  要理解
        }
    }

    public static void main(String[] args) {
        Topic_17_letterCombinations solution = new Topic_17_letterCombinations();
        System.out.println(solution.letterCombinations("23"));
    }
}
