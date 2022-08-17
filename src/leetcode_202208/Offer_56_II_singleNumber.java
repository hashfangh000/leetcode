package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * @author: fanghao
 * @create: 2022/8/17
 **/
public class Offer_56_II_singleNumber {
    public int singleNumber(int[] nums) {
        //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
        int[] k = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                k[i] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (k[i] % 3) << i;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer_56_II_singleNumber solution = new Offer_56_II_singleNumber();
        System.out.println(solution.singleNumber(new int[]{1, 7, 7, 7, 9, 9, 9}));
    }
}
