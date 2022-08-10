package leetcode_202207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode_fh
 * @description: 求数据中的所有逆序对
 * @author: fanghao
 * @create: 2022-07-04 19:28
 **/

public class S_reverseSum {
     static int ans;
    public void reverseSum(int[] arr){

        if (arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int l, int r) {
        if (l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        while(p1 <= mid && p2 <= right){
            if(arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            }else{
                help[i++] = arr[p2++];
                ans += mid - p1 + 1;
            }
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
    }

    public static void main(String[] args) {
        S_reverseSum solution = new S_reverseSum();
        solution.reverseSum(new int[]{3, 4, 5, 0 ,1});
        System.out.println(ans);
    }
}
