package leetcode_202207;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/contains-duplicate/
 * @author: fanghao
 * @create: 2022-07-07 16:36
 **/

public class Solution_217containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length;i++) {
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
