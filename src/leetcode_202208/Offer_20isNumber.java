package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @author: fanghao
 * @create: 2022/8/20
 **/
public class Offer_20isNumber {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        boolean isNum = false, isDot = false, iseOrE = false;
        char[] str = s.trim().toCharArray();
       for (int i = 0; i < str.length; i++){
           if(str[i] >= '0' && str[i] <= '9') isNum = true;
           else if(str[i] == '.') {
               if(isDot || iseOrE) return false;
                isDot = true;
            }else if(str[i] == 'e' || str[i] == 'E') {
                if(!isNum || iseOrE)return false;//e 或 E 前面没有数 或者 前面还是e 或 E
                iseOrE = true;          //标记 现在有 e 或 E
                isNum = false;          //重置isNum，因为 'e' 或 'E'之后也要接整数
            }else if(str[i] == '-' || str[i] == '+') {
               if(i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;  //正负号 只能出现一个位置，或者 在 e 'E'的后面
            }else return false;
       }
       return isNum;
    }

    public static void main(String[] args) {
        Offer_20isNumber solution = new Offer_20isNumber();
        String s = "   3";

        System.out.println(solution.isNumber("-1E-16"));

    }
}
