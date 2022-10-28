package leetcode_202210;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/subsets/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/27
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 **/
public class Hot_78subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();        //解集
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++){
            int size = ans.size();                          //已经有几个解集
            for(int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<>(ans.get(j));       //把解集中的添加进去之后，再把当前nums[i]添加到每一个子集中
                list.add(nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}
