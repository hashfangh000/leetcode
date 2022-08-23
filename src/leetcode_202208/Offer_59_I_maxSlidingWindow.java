package leetcode_202208;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @author: fanghao
 * @create: 2022/8/22
 **/
public class Offer_59_I_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < k; i++){
            //将大的加入到deque 使得 deque保持非递减
            while(!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[index++] = deque.peekFirst();
        for (int i = k; i < nums.length; i++){
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            deque.addLast(nums[i]);
            res[index++] = deque.peekFirst();
        }
        return res;
    }
    public static void main(String[] args) {
        Offer_59_I_maxSlidingWindow solution = new Offer_59_I_maxSlidingWindow();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
