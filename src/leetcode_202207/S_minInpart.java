package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: 找无序数组中局部最小值，比左右都要小的值
 * @author: fanghao
 * @create: 2022-07-22 19:05
 **/

public class S_minInpart {
    public int minInpart(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        //边界条件
        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int l = 1, r = arr.length - 2;
        int mid = 0;
        while (l < r){
            mid = l + (r - l) / 2;
            //mid > mid - 1，如 ...4,5...，局部最小值一定在mid左边,r = mid - 1
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            }
            //mid > mid + 1，如 ...4,3...，局部最小值一定在mid右边,r = mid + 1
            else if(arr[mid] > arr[mid + 1]){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return l;
    }
}
