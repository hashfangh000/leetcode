package leetcode_202209.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode.cn/problems/integer-to-roman/
 * @author: fanghao
 * @create: 2022/9/2
 **/
public class Hot_12intToRoman {


    public String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"I");
        map.put(1,"IV");
        map.put(2,"V");
        map.put(3,"IX");
        map.put(4,"X");
        map.put(5,"XL");
        map.put(6,"L");
        map.put(7,"XC");
        map.put(8,"C");
        map.put(9,"CD");
        map.put(10,"D");
        map.put(11,"CM");
        map.put(12,"M");
        StringBuffer ans = new StringBuffer();
        int[] arr = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        for (int i = arr.length - 1; i >= 0; i--){
            int cur = arr[i];
            while (cur <= num && num >= 0){
                num = num - cur;
                ans.append(map.get(i));
            }
        }
        return ans.toString();
    }
}
