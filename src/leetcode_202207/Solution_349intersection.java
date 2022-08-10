package leetcode_202207;

import java.util.Arrays;

/**
 * @program: leetcode_202207
 * @description: https://leetcode.cn/problems/intersection-of-two-arrays/
 * @author: fanghao
 * @create: 2022/7/1 23:04
 *
 * 求两个数组交集
 */
public class Solution_349intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] ans = new int[len1 + len2];
        int index = 0, index1 = 0,index2 = 0;
        while (index1 < len1 && index2 < len2){
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2){
                if (index == 0 || num1 != ans[index - 1]){
                    ans[index++] = num1;
                }
                index1++;
                index2++;
            }else if(num1 < num2){
                index1++;
            }else{
                index2++;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}