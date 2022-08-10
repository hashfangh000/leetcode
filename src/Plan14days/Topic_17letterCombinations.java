package Plan14days;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Topic_17letterCombinations {
    String[] strings = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> ans = new ArrayList<>();
        if (len == 0){
            return ans;
        }
        backtrack(ans, digits, new StringBuffer(), 0);
        return ans;
    }

    private void backtrack(List<String> ans, String digits, StringBuffer stringBuffer, int index) {
        if (index == digits.length()){
            ans.add(stringBuffer.toString());
            return;
        }
        char c = digits.charAt(index);
        int position = c - '0';
        String str = strings[position];
        for (int i = 0; i < str.length(); i++){
            stringBuffer.append(str.charAt(i));
            backtrack(ans, digits, stringBuffer, index + 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    public static void main(String[] args) {
        Topic_17letterCombinations solution = new Topic_17letterCombinations();
        System.out.println(solution.letterCombinations("23"));

    }
}
