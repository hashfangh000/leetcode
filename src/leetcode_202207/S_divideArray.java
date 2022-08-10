package leetcode_202207;

import java.util.Arrays;

/**
 * @program: leetcode_fh
 * @description: 将数组中小于等于num的数放在数组左边，大于num的数放在右边
 * @author: fanghao
 * @create: 2022-07-04 20:27
 **/

public class S_divideArray {
    public void divideArray(int[] arr, int num){

        int l = 0;
        int less = l - 1; //小于num的数的边界，0~l上的数全部小于num
        int r = arr.length;
        while(l < r){
            if(arr[l] <= num){
                swap(arr, ++less, l++);
            }else{
                l++;
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        S_divideArray sDivideArray = new S_divideArray();
        int[] arr = {5,8,5,11,3,3,6};
        sDivideArray.divideArray(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
