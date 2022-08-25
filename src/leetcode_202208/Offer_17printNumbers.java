package leetcode_202208;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @author: fanghao
 * @create: 2022/8/24
 **/
public class Offer_17printNumbers {
//    public int[] printNumbers(int n) {
//        int len = (int) Math.pow(10, n);
//        int[] res = new int[len - 1];
//        for (int i = 0; i < len - 1; i++){
//            res[i] = i + 1;
//        }
//        return res;
//    }

    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        num = new char[n];
        res = new int[(int) (Math.pow(10, n) - 1)];
        dfs(0);
        return res;
    }
    private void dfs(int n) {
        if (n == this.n) {
            String tmp = String.valueOf(num);
            int curNum = Integer.parseInt(tmp);
            if (curNum!=0) res[count++] = curNum;
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[n] = i;
            dfs(n + 1);
        }
    }

    public static void main(String[] args) {
        Offer_17printNumbers solution = new Offer_17printNumbers();
        System.out.println(Arrays.toString(solution.printNumbers(2)));
    }
}
