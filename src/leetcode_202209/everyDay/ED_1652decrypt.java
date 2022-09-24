package leetcode_202209.everyDay;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/defuse-the-bomb/
 * @author: fanghao
 * @create: 2022/9/24
 **/
public class ED_1652decrypt {
    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] tmp = Arrays.copyOfRange(code, 0, len);
        if(k == 0){
            for(int i = 0; i < len; i++){
                code[i] = 0;
            }
        }else if(k > 0){
            for(int i = 0; i < len; i++){
                int cur = 0;
                for(int j = 1; j <= k; j++){
                    cur += tmp[(i + j) % len];
                }
                code[i] = cur;
            }
        }else{
            k = -k;
            for(int i = 0; i < len; i++){
                int cur = 0;
                for(int j = 1; j <= k; j++){
                    cur += tmp[(i + len - j) % len];
                }
                code[i] = cur;
            }
        }
        return code;
    }

    public static void main(String[] args) {
        decrypt(new int[]{5,7,1,4}, -2);
    }
}
