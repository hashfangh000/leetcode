package leetcode_202210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/3sum/
 * @author: fanghao
 * @create: 2022/10/31
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  排序 + 双指针
 * 定义一个位置i，用双指针找剩下两个位置，分别从左到右和从右到左确定剩下两个位置，分别用left = i + 1, right = len - 1表示
 * 注意：不包含重复到三元组，如果 nums[i] == nums[i-1]则跳过
 *  i位置固定好之后，如果遇到nums[left] == nums[left + 1]，也跳过
 *  i位置固定好之后，如果遇到nums[right] == nums[right + 1]，也跳过 来保证left 和 right 找到到数也是不重复的
 **/
public class Hot_15threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len < 3 || nums == null){
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++){                  //第一个数字位置i
            if(nums[i] > 0){                            //第一个位置大于0了，下面的数都大于0
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){        //同样的数字不选2次,continue选别的
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) {                                // 三数和小， 负数太多，向右找
                    left++;
                }else if (sum > 0){                          // 正数太大，要加比right位置上小的
                    right--;
                }else{
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    ans.add(new ArrayList<>(cur));
                    while(left < right && nums[left] == nums[left + 1]){        //去除第二位置重复的
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){  //去除第三位置重复的
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
