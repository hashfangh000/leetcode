package leetcode_202209.everyDay;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 * @author: fanghao
 * @create: 2022/9/1
 **/
public class ED_1475finalPrices {
    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++){      //O(n)
            int j = i;
            while (j < len && (j <= i || prices[j] > prices[i])){   //O(n)
                j++;
            }
            if(j >= len){
                res[i] = prices[i];
            }else{
                res[i] = prices[i] - prices[j];
            }
        }       //O(N)
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));
        System.out.println(Arrays.toString(finalPrices(new int[]{1,2,3,4,5})));
    }
}
