package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/find-the-duplicate-number/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/18
 *  查找数组中重复数字转化为判断链表是否有环
 **/
public class Hot_287findDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        //模拟在链表中的快慢指针
        do{
            slow = nums[slow];      //慢指针走1步
            fast = nums[nums[fast]];    //快指针走2步
        }while(slow != fast);
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
