package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @author: fanghao
 * @create: 2022/8/16
 **/
public class Offer_65add {
    public int add(int a, int b) {
        if (b == 0){
            return a;
        }else{
            int carry = (a & b) << 1;
            a = a ^ b;
            return add(a, carry);
        }
    }

    public static void main(String[] args) {
        Offer_65add solution = new Offer_65add();
        System.out.println(solution.add(5, 6));
    }
}
