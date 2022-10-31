package leetcode_202210;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode.cn/problems/two-sum/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/29
 **/
public class Hot_1twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){      //将nums[i] 放到key中，value为数组下标，return的也是数组下标
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
