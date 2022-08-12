package leetcode_202208;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @author: fanghao
 * @create: 2022/8/11
 **/
public class Offer_61isStraight {
    public boolean isStraight(int[] nums) {
        //顺子 ： 数组除了 0 意外 都不重复
        //       max - min < 5
        Arrays.sort(nums);
        int count_0 = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                count_0++;
            }else if(nums[i] == nums[i + 1]){
                return false;
            }
        }

        return nums[4] - nums[count_0] < 5;
    }
}
