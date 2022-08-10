package leetcode_202207;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/replace-words/
 * @author: fanghao
 * @create: 2022-07-07 13:59
 **/

public class Solution_648replaceWords {
    //
    public String replaceWords(List<String> dictionary,String sentence) {
        /*StringBuffer cur = new StringBuffer();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < sentence.length(); i++){
            char ch = sentence.charAt(i);
            if (ch != ' '){
                cur.append(ch);
                if (dictionary.contains(cur.toString())){
                    while (i < sentence.length() && sentence.charAt(i) != ' '){
                        i++;
                    }
                    i--;
                }
                res.append(ch);
            }else{
                cur = new StringBuffer();
                res.append(" ");
            }
        }
        return res.toString();*/
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution_648replaceWords solution_648replaceWords = new Solution_648replaceWords();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        System.out.println(solution_648replaceWords.replaceWords(dictionary, "the cattle was rattled by the battery"));
//        System.out.println(solution_648replaceWords.replaceWords(dictionary, "aadsfasf absbs bbab cadsfafs"));
    }
}
