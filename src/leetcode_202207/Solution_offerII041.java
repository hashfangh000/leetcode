package leetcode_202207;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/qIsx9U/
 * @author: fanghao
 * @create: 2022-07-16 09:45
 **/

public class Solution_offerII041 {
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    double sum;
    int currentSize = 0;
    public Solution_offerII041(int size) {
        queue = new ArrayDeque<Integer>();
        this.currentSize = size;
        sum = 0;
    }

    public double next(int val) {
        if (currentSize == queue.size()){
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
