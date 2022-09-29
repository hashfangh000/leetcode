package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/sort-colors/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/29
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 快速排序 荷兰国旗问题
 **/
public class Hot_75sortColors {
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int less = l - 1, more = r + 1;        //定义左右边界，左边界都是等于0的数，右边界都是等于2的数字，左边-右边都是等于1的数
        while(l < more){                       //当带排元素还没有到右边界时，
            if(nums[l] > 1){
                swap(nums, l, --more);
            }else if(nums[l] < 1){
                swap(nums, l++, ++less);
            }else {
                l++;
            }
        }
    }
}
