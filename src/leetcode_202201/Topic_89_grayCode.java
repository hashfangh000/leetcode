package leetcode_202201;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种方法基于格雷码是反射码的事实，利用递归的如下规则来构造：
 * 1、1位格雷码有两个码字
 * 2、(n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
 * 3、(n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1 [4]
 * 4、n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
 *
 *    二进制转换为格雷码 ：
 *    假设n位二进制数 为 b,  对应的格雷码为g 转化规则：
 *                          g(i)=b(i+1)⊕b(i),    0≤i<n
 *    g(i) 和 b(i) 分别表示 g 和 b 的第 i 位，且 b(n)=0。
 *
 */
public class Topic_89_grayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++){
            ans.add((i >> 1) ^ i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Topic_89_grayCode solution = new Topic_89_grayCode();
        //List<Integer> ans = solution.grayCode(4);
//        for (Integer an : ans) {
//            System.out.print(an + " ");
//        }
        System.out.println( 1 << 4);
    }
}
