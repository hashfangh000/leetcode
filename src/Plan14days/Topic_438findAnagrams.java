package Plan14days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Topic_438findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> ans = new ArrayList<>();
//        if (s.length() < p.length()){
//            return ans;
//        }else{
//            int i = 0, j = p.length();
//            while(i < s.length() - j + 1){
//                String a = s.substring(i, i + j);
//                if (checkString(a, p)){
//                    ans.add(i);
//                }
//                i++;
//            }
//        }
//        return ans;
        List<Integer> ans = new ArrayList<>();
        int lens = s.length(),lenp = p.length();
        if (lens < lenp)
            return ans;
        int[] checks = new int[26];
        int[] checkp = new int[26];
        for (int i = 0; i < lenp; i++){
            checks[s.charAt(i) - 'a']++;
            checkp[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(checks, checkp)){
            ans.add(0);
        }
        for (int i = lenp; i < lens; i++){
            checks[s.charAt(i - lenp) - 'a']--;
            checks[s.charAt(i) - 'a']++;
            if (Arrays.equals(checks, checkp)){
                ans.add(i - lenp + 1);
            }
        }
        return ans;
    }
    private boolean checkString(String a, String b){
        int[] checka = new int[26];
        int[] checkb = new int[26];
        for (int i = 0; i < a.length(); i++){
            checka[Integer.valueOf(a.charAt(i) - 'a')]++;
            checkb[Integer.valueOf(b.charAt(i) - 'a')]++;
        }
        if (Arrays.equals(checka, checkb)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Topic_438findAnagrams solution = new Topic_438findAnagrams();
        List<Integer> ans = solution.findAnagrams("bab", "aa");

//        System.out.println(str.charAt(2));
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
