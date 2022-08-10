package leetcode_202205;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 *
 * @author fanghao on 2022/5/9
 */
public class Topic_442findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while (nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (nums[i] - 1 != i){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

    public static void main(String[] args) {
        Topic_442findDuplicates solution = new Topic_442findDuplicates();
        System.out.println(solution.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}