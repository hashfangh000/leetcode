package leetcode_202210;

/**
 * @description: https://leetcode.cn/problems/remove-element/
 * @author: fanghao
 * @create: 2022/11/1
 **/
public class Hot_27removeElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int left = -1, right = nums.length - 1;
        while(i <= right){
            if(nums[i] != val){
                left++;
                i++;
            }else{
                swap(nums, left + 1, right--);
            }
        }
        return left;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        removeElement(nums,2);
    }
}
