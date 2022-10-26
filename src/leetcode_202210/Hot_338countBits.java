package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/counting-bits/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/25
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * 对于整数x, 如果存在最大y, 且y <= x, y是2得整数次幂，y的二进制1的个数为1
 * 令 整数i 的二进制 1的个数为bits[i]，
 * 则整数x的二进制 1的个数为1 + bits[x - y]
 * 判断y是否为2的整数次幂，y & (y - 1) == 0即可
 * 整数0 中 1的个数为0,
 * 先找到当前x中 最大的y，更新y，
 **/
public class Hot_338countBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int heighty = 0;
        for(int i = 1; i <= n; i++){
            if((i & (i - 1)) == 0){
                heighty = i;            //更新y
            }
            ans[i] = ans[i - heighty] + 1;
        }
        return ans;
    }
}
