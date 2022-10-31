package leetcode_202210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/4sum/
 * @author: fanghao
 * @create: 2022/10/31
 **/
public class Hot_18fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length < 4){
            return ans;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 3; i++){       //第一个数
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //-109 <= nums[i] <= 109 用long
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {        //最小的组合大于target,不用找了
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {      //最大的组合小于target，还可以继续找
                continue;
            }
            for(int j = i + 1; j < len - 2; j++){                       //第二个数
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){      //
                    break;
                }
                if((long)nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target){       //
                    continue;
                }
                int left = j + 1, right = len - 1;              //第三、第四个数
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        fourSum(nums, 8);
    }
}
