package leetcode_202207;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: leetcode_fh
 * @description: 快速排序
 * @author: fanghao
 * @create: 2022-07-04 21:13
 **/

public class S_quickSort {

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void quickSort(int[] arr, int l, int r){
        if(l < r){
            //随机找l~r范围上的一个数，
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            //partition后，l位置左边上的都是比随机找的数小，r右边都比随机数要大或等于
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1; //左边界
        int more = r;   //右边界
        //这里比较的是在swap(arr, l + (int)(Math.random() * (r - l + 1)), r);中与r位置上的元素，到这一步arr[r]是随机找的数
        while (l < more){
            if (arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }
        //随机找的数和r换回来
        //也可以写swap(arr, l, r);
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        S_quickSort sort = new S_quickSort();
        int[] arr = {5,8,5,11,3,3,6};
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
