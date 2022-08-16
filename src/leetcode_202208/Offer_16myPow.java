package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @author: fanghao
 * @create: 2022/8/15
 **/
public class Offer_16myPow {
    public double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0){
            x = 1 / x;
            b = -b;
        }
        while (b > 0){
            //判断最右一位是否为1，这里是转换为二进制算
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;

//        long N = n;
//        return N > 0 ? PostivatePow(x, N) : 1.0 / PostivatePow(x, -N);
    }
    private double PostivatePow(double x, long n){
        if (n == 0){
            return 1.0;
        }
        double y = PostivatePow(x, n / 2);
        return n % 2 == 1 ? y * y * x : y * y ;
    }

    public static void main(String[] args) {
        Offer_16myPow solution = new Offer_16myPow();
        System.out.println(solution.myPow(2,-3));

    }
}
