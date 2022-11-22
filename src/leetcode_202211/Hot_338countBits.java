package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/counting-bits/description/
 * @author: fanghao
 * @create: 2022/11/21
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 动态规划-最低有效位。
 * 正整数x， 二进制右移一位等价于将其二进制表示的最低位去掉，得到」x/2」向下取整，如果b[」x/2」]已知，则可以得到b[x]的值
 * x为奇数：b[x] = b[x >> 1] + 1
 * x 为偶数 ： b[x] = b[x >> 1]
 * 先判断x的最后一个位是不是1，等价于x是奇数还是偶数
 **/
public class Hot_338countBits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; ++i){
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
