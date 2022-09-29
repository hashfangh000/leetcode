package leetcode_202209.everyDay;

/**
 * @description: https://leetcode.cn/problems/string-rotation-lcci/
 * @author: fanghao
 * @create: 2022/9/29
 **/
public class ED_0109isFlipedString {
    public static boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int len = len1;
        if(len1 != len2){
            return false;
        }
        if(len1 == 0){
            return true;
        }
        //"aterbottle"
        //"erbottlewat"
        // e
        // e
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (s1.charAt((i + j) % len) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        isFlipedString("waterbottle","erbottlewat");
    }
}
