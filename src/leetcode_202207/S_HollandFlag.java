package leetcode_202207;

import java.util.Arrays;

/**
 * @program: leetcode_fh
 * @description: 荷兰国旗问题 将数组元素按照num 小于 等于 大于分类
 * @author: fanghao
 * @create: 2022-07-04 20:38
 **/

public class S_HollandFlag {
    public void HollandFlag(int[] arr, int num){
        int r = arr.length;
        int l = 0;

        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < num){
                swap(arr, ++less, l++);
            }else if(arr[l] > num){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }

//        for (int i = 0; i < arr.length; i++){
//            if (arr[i] == num){
//                mid++;
//                continue;
//            }else if(arr[i] < num){
//                swap(arr, left +1, i);
//                left++;
//            }else if(left + mid + 1 != right){
//                swap(arr, right - 1, i);
//                right--;
//                i--;
//            }
//        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        S_HollandFlag solution = new S_HollandFlag();
        int[] arr = {5,8,5,11,3,3,6};
        solution.HollandFlag(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
