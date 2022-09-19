package leetcode_202209.everyDay;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 * @author: fanghao
 * @create: 2022/9/19
 **/
public class ED_1636frequencySort {
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,1,3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
}
