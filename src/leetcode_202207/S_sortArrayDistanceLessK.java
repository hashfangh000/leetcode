package leetcode_202207;

import java.util.PriorityQueue;

/**
 * @program: leetcode_fh
 * @description: 使数组几乎有序，数组排序好的位置，元素移动的距离不超过K
 * @author: fanghao
 * @create: 2022-07-21 17:28
 **/

public class S_sortArrayDistanceLessK {
    public void sortedArrDistanceLessK(int[] arr, int k){
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index <= Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}
