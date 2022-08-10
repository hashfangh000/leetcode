package leetcode_202207;

/**
 * @program: leetcode_fh
 * @description: 求数组中，每一个数左边比当前数小的数累加起来
 * @author: fanghao
 * @create: 2022-07-04 19:05
 **/

public class S_smallSum {
    public int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private int process(int[] arr, int l, int r) {
        if(l == r){
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        int res = 0;
        while(p1 <= mid && p2 <= right){
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= right){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[left + i] = help[i];
        }
        return res;
    }
}
