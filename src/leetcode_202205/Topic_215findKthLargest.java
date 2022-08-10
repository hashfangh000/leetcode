package leetcode_202205;

import java.util.Random;

public class Topic_215findKthLargest {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        return QuickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int Partition(int[] nums, int left, int right) {
        int random = left + rand.nextInt(right - left + 1);     //基准
        swap(nums, left, random);
        while (left < right) {
            while (left < right && nums[left] <= nums[right]) {
                right--;
            }
            swap(nums, left, right);

            while (left < right && nums[left] <= nums[right]) {
                left++;
            }
            swap(nums, left, right);
        }
        return left;
    }

    //每次position划分 得到位置position，为该元素的最终位置，要返回第k大的数字，也就是倒数第k个位置的元素，正数 len - k
    // 则划分到位置len - k时，此位置也是该元素的最终位置
    public int QuickSort(int[] nums, int left, int right, int p) {
        int position = Partition(nums, left, right);
        if (position < p) {
            return QuickSort(nums, position + 1, right, p);
        } else if (position > p) {
            return QuickSort(nums, left, position - 1, p);
        } else {
            return nums[position];
        }
    }

    public static void main(String[] args) {
        Topic_215findKthLargest solution = new Topic_215findKthLargest();
        System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

    }
}
