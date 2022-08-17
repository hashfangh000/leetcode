package leetcode_202208;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @author: fanghao
 * @create: 2022/8/17
 **/
public class Offer_56_i_singleNumbers {
    public int[] singleNumbers(int[] nums) {
        int eor = 0;
        int onlyOne = 0;        //a 或者 b
        for(int num : nums){
            eor ^= num;
        }
        //eor = a ^ b, 其中某一位 一定为1, 提取最右侧的1，
        int rightOne = eor & (~eor + 1);
        //让 最右一位一定为1 的数字 相互 ^,可以得到 出现奇数次的数
        for (int num : nums){
            if ((num & rightOne) == 0){
                onlyOne ^= num;
            }
        }
        return new int[]{onlyOne ^ eor, onlyOne };
    }

    public static void main(String[] args) {
        Offer_56_i_singleNumbers solution = new
                Offer_56_i_singleNumbers();
        System.out.println(Arrays.toString(solution.singleNumbers(new int[]{1,2,10,4,1,4,3,3})));
    }
}
