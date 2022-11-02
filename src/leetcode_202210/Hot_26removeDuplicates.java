package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * @author: fanghao
 * @create: 2022/11/1
 **/
public class Hot_26removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0;
//        while(right < len){
//            int cur = nums[left];
//            right = left + 1;
//            while(right < len && nums[right] == cur){
//                right++;
//            }
//            if(right < len){
//                for(int i = left + 1; i < right; i++){
//                    nums[i] = nums[right];
//                }
//            }
//            left++;
//        }
//        return left;
        for (int j = 1; j < len; j++){
            if(nums[left] != nums[j]){
                left++;
                nums[left] = nums[j];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums2 = {1,1,2};
        removeDuplicates(nums);
    }
}
