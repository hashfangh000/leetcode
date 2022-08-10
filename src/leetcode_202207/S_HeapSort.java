package leetcode_202207;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: leetcode_fh
 * @description: 堆排序
 * @author: fanghao
 * @create: 2022-07-21 16:09
 **/

public class S_HeapSort {

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1; //左孩子
        while (left < heapSize){
            //两个孩子最大值
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父 和 孩子 最大值
            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
    public void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
//        for (int i = 0; i < arr.length; i++){ //O(n)
//            heapInsert(arr, i);               //O(logN)
//        }
        for (int i = arr.length; i >= 0; i--){
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){               //O(N)
            heapify(arr, 0, heapSize);  //O(logN)
            swap(arr, 0, --heapSize);       //O(1)
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,8,2,3,4,5,0};
        S_HeapSort sort = new S_HeapSort();
        sort.heapSort(arr);
//        for (int i = 0; i < arr.length; i++){ //O(n)
//            heapInsert(arr, i);               //O(logN)
//        }
//        System.out.println(arr[0]);
        System.out.println(Arrays.toString(arr));

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(1);

    }
}
