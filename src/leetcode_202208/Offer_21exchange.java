package leetcode_202208;

import java.util.Arrays;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @author: fanghao
 * @create: 2022-08-05 21:04
 **/

public class Offer_21exchange {
    public int[] exchange(int[] nums) {
        int l = -1;
        int index = 0;
        while(index < nums.length){
            if(nums[index] % 2 == 0){
                index++;
            }else{
                swap(nums, ++l, index++);
            }
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Offer_21exchange so = new Offer_21exchange();
        so.exchange(new int[]{1,2,3,4});

    }
}
