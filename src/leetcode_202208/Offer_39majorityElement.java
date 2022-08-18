package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @author: fanghao
 * @create: 2022/8/17
 **/
public class Offer_39majorityElement {
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    public int majorityElement(int[] nums) {
        //题说明数组非空，且有很多元素
        int candidate = nums[0];
        int count = 1;  //记录当前candidate出现的次数
        for (int i = 1; i < nums.length; i++){
            // 下一个也是candidate
            if ((candidate ^ nums[i]) == 0){
                count++;
            }else{
                count--;
                if (count == 0){
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Offer_39majorityElement solution = new Offer_39majorityElement();
        System.out.println(solution.majorityElement(new int[]{3,3,4}));
    }
}
