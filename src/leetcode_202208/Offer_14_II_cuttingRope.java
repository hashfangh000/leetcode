package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 * @author: fanghao
 * @create: 2022/8/25
 **/
public class Offer_14_II_cuttingRope {
    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        long ret = 1;
        int remainder = n % 3, mod = 1000000007;
        for (int i = 1; i < quotient; i++){
            ret = 3 * ret % mod;
        }
        if (remainder == 0) {
            return (int)(ret * 3 % mod);
        } else if (remainder == 1) {
            return (int)(ret * 4 % mod);
        } else {
            return (int)(ret * 6 % mod);
        }
    }

    public static void main(String[] args) {
        Offer_14_II_cuttingRope solution = new Offer_14_II_cuttingRope();
        System.out.println(solution.cuttingRope(127));
        System.out.println(Integer.MAX_VALUE);
    }
}
