package leetcode_202208;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * @author: fanghao
 * @create: 2022/8/17
 **/
public class Offer_66_constructArr {

    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        Offer_66_constructArr solution = new Offer_66_constructArr();
        System.out.println(Arrays.toString(solution.constructArr(new int[]{4,5,1,8,2})));
    }
}
