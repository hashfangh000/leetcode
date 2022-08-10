package leetcode_202206;

import java.util.Arrays;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * @author: fanghao
 * @create: 2022-06-16 10:25
 **/

public class Topic_532findPairs {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len - 1; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < len; j++){
                if (j != i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int distance = nums[j] - nums[i];
                if (distance == k){
                    ans ++;
                }else if(distance < k){
                    continue;
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Topic_532findPairs solution = new Topic_532findPairs();
        System.out.println(solution.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
        System.out.println(solution.findPairs(new int[]{3, 1, 1, 4, 5}, 2));
    }
}
