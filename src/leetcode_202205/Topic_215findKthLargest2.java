package leetcode_202205;

public class Topic_215findKthLargest2 {
    public int findKthLargest(int[] nums, int k) {
        return QuickSort(nums, 0, nums.length - 1, nums.length - k);
    }
    //复杂度比较高
    public int Partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pivot)right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot)left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
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
        Topic_215findKthLargest2 solution = new Topic_215findKthLargest2();
        System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
