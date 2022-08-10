package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/majority-element/
 * @author: fanghao
 * @create: 2022-07-07 14:57
 **/

public class Solution_169majorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
       for (int i = 1; i < nums.length; i++){
           if (count == 0){
               res = nums[i];
               count++;
               continue;
           }
            if ((res ^ nums[i]) == 0){
                count++;
            }else{
                count--;
            }
       }
       return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,3,4,2,2};
        Solution_169majorityElement solution = new Solution_169majorityElement();
        System.out.println(solution.majorityElement(nums));
    }
}
