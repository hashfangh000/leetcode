package leetcode_202210;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/25
 **/
public class Hot_448findDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int[] help = new int[len];
        for(int i = 1; i <= len; i++){
            help[i - 1] = i;
        }
        for(int num : nums){
            help[num - 1] = 0;
        }
        for (int i = 0; i < len; i++){
            if (help[i] != 0){
                res.add(help[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(nums);
    }
}
