package leetcode_202209.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode.cn/problems/two-sum/
 * @author: fanghao
 * @create: 2022/8/30
 * 查找数组中 是否存在和为target的值，同一个元素不能使用多次，返回两个数的下标；
 *  遍历数组，对于当前nums[i]，如果数组中存在target - nums[i] ， 就是返回结果，
 *  对于找target - nums[i] 的下标，用哈希表保存nums[i]的位置
 *  (key,value) -> (nums[i], i), map.get(nums[i]) -> i 同样 map.get(target-nums[i]) 可以得到另一个位置，return new int[]{i, map.get(target-nums[i])}
 *
 **/
public class Hot_01twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();    //空间复杂度 O(n)
        for(int i = 0; i < nums.length; i++){           // O(n)
            if(map.containsKey(target - nums[i])){      //map.containsKey - > O(n)
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];                          //整体复杂度 O(n)
    }
}
