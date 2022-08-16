package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @author: fanghao
 * @create: 2022/8/16
 **/
public class Offer_15hammingWeight {
    // 对于二进制:
    //          n : 10101000
    //      n - 1 : 10100111
    //n & (n - 1) : 10100000
    //  此时 最右边的1消掉了， 计数res++；
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        int ans = 0;
//        while(n != 0){
//            ans += n & 1;
//            n = n >>> 1;
//        }
//        return ans;
        int ans = 0;
        while (n != 0){
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
