package leetcode_202207;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/largest-number/
 * @author: fanghao
 * @create: 2022-07-15 11:14
 **/

public class Solution_179largestNumber {
    public String largestNumber(int[] nums) {
        StringBuffer ans = new StringBuffer();
        String[] strings = new String[nums.length];
        int index = 0;
        for (int num : nums) {
            strings[index] = String.valueOf(num);
            index++;
        }

        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String s = o1 + o2;
                String ss = o2 + o1;
                int index = 0;
                while (index < s.length()){
                    if (ss.charAt(index) == s.charAt(index)){
                        index++;
                    }else{
                        return Integer.valueOf(s.charAt(index)) - Integer.valueOf(ss.charAt(index));
                    }
                }
                return 0;
            }
        });
        /*
        for (int i = 0; i < strings.length - 1; i++) {
            String s1 = strings[i];
            for (int j = i + 1; j < strings.length; j++){
                String s2 = strings[j];
                if(compare(s1, s2)){    //s1 > s2
                    swap(strings, i, j);
                }
            }
        }*/
        for(int i = strings.length - 1; i >= 0; i--){
            if (ans.toString().equals("") && strings[i].equals("0")){
                continue;
            }
            ans.append(strings[i]);
        }
        return ans.toString().equals("") ? "0" : ans.toString();
    }

    private void swap(String[] strings, int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    private boolean compare(String s1, String s2) {
        String s = s1 + s2;
        String ss = s2 + s1;
        int len1 = s.length();
        int p1 = 0, p2 = 0;
        while (p1 < len1){
            if (s.charAt(p1) != ss.charAt(p2)){
                return s.charAt(p1) > ss.charAt(p2);
            }else{
                p1++;p2++;
            }
        }
        return true; // 相等不妨为true
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
//        String[] nums = {"1","4","7","2","5","8","0","3","6","9"};

        Solution_179largestNumber solution = new Solution_179largestNumber();
        System.out.println(solution.largestNumber(nums));

    }
}
