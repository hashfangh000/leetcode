package leetcode_202209.hot100;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/3sum/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/2
 **/
public class Hot_15threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length  < 3 || nums == null){
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){      //i 是 三元组中的第一个数
            if (nums[i] > 0){       //第一个数大于0 后面都大于0 相加肯定不为0
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){       //第一个数用过了，就不能再用了
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[i]);
                    current.add(nums[left]);
                    current.add(nums[right]);
                    ans.add(current);
                    // 注意在不重复的三元组 如果这个数用过了 就不要再用了 去重
                    /**
                     * 例如 -4, -1, -1, 0, 1, 2*, 2
                     * 当前ans中已经有 -1, -1, 2的三元组
                     * 则下一次就取2*
                     */
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum < 0){             //说明当前sum比较小 要加大的数
                    left++;
                }else if (sum > 0){             //说明当前sum比较大，要加小的数
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Hot_15threeSum solution = new Hot_15threeSum();
        List<List<Integer>> ans = solution.threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
