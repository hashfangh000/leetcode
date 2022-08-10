package leetcode_202205;

import java.util.Arrays;
import java.util.Random;

public class Sort_QuickSort {
    Random rand = new Random();
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int partition(int[] nums, int left, int right){
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
    public void quicksort(int[] nums, int low, int high){
        if (low < high){
            int pivotpos = partition(nums, low, high);
            quicksort(nums, low, pivotpos - 1);
            quicksort(nums, pivotpos + 1, high);
        }
    }

    public static void main(String[] args) {
        Sort_QuickSort quickSort = new Sort_QuickSort();
        int[] nums = {3,2,1,5,6,4};
        quickSort.quicksort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
