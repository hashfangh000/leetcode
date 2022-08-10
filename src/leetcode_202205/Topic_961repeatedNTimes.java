package leetcode_202205;

import java.util.Random;

public class Topic_961repeatedNTimes {
    public int repeatedNTimes(int[] nums) {
//        int n = nums.length;
//        Random random = new Random();
//        while(true){
//            int x = random.nextInt(n), y = random.nextInt(n);
//            if(x != y && nums[x] == nums[y]){
//                return nums[x];
//            }
//        }
        int n = nums.length;
        for (int gap = 1; gap <= 3; ++gap) {
            for (int i = 0; i + gap < n; ++i) {
                if (nums[i] == nums[i + gap]) {
                    return nums[i];
                }
            }
        }
        // 不可能的情况
        return -1;
    }

    public static void main(String[] args) {
        Topic_961repeatedNTimes solution = new Topic_961repeatedNTimes();
        System.out.println(solution.repeatedNTimes(new int[]{1, 2, 3, 3}));
    }
}
