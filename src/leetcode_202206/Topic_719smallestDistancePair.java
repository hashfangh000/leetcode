package leetcode_202206;

import java.util.Arrays;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * @author: fanghao
 * @create: 2022-06-15 10:34
 **/

public class Topic_719smallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        /*int n = nums.length;
        int[] distance = new int[999999];
        int index = 0;
        for (int i = 0; i < distance.length; i++){
            distance[i] = -1;
        }
        int pos;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                pos = Math.abs(nums[j] - nums[i]);
                distance[pos]++;
            }
        }

        while (k > 0){
            if (distance[index] == -1){
                index++;
            }else{
                k = k - distance[index] - 1;
                index++;
            }
        }
        return index - 1;*/
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Topic_719smallestDistancePair solution = new Topic_719smallestDistancePair();
//        System.out.println(solution.smallestDistancePair(new int[]{1, 6, 1}, 3));
        System.out.println(solution.smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18));
    }
}
