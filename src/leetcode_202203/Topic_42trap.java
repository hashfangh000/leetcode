package leetcode_202203;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Topic_42trap {
    public int trap(int[] height) {
        /**
         * 双指针
         */
        int ans = 0;
        int size = height.length;
        int left = 0, right = size - 1;
        int left_max = 0, right_max = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= left_max){
                    left_max = height[left];
                }else{
                    ans += (left_max - height[left]);
                }
                left++;
            }else {
                if (height[right] >= right_max){
                    right_max = height[right];
                }else {
                    ans += (right_max - height[right]);
                }
                right--;
            }
        }
        return ans;

        /**
         * 动态规划
         */
        /*
        if(height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--){
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++){
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;

         */
        /**
         * 暴力解
         */
        /*
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++){
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--){
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++){
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left,max_right) - height[i];
        }
        return ans;

         */
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        Topic_42trap solution = new Topic_42trap();
        System.out.println(solution.trap(height));
    }
}
