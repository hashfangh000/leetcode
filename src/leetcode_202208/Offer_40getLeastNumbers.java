package leetcode_202208;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 * @author: fanghao
 * @create: 2022/8/11
 **/
public class Offer_40getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k == 0){
//            return new int[0];
//        }
//        Arrays.sort(arr);
//        return Arrays.copyOfRange(arr, 0, k);
        int[] ans = new int[k];
        if (k == 0) { // 排除 0 的情况
            return ans;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            ans[i] = queue.poll();
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,10,9,7,0,2};
        Offer_40getLeastNumbers solution = new Offer_40getLeastNumbers();
        solution.getLeastNumbers(nums, 3);
    }
}
