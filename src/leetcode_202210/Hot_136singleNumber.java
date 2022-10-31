package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/single-number/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/29
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 *
 * nums : 4, 1, 2, 1, 2
 * 4
 *
 * 1 & 1 = 0
 * 1 ^ 1 = 0
 * 2 ^ 2 = 0
 * 0 ^ 3 = 3
 **/
public class Hot_136singleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
