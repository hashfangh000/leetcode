package leetcode_202208;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @author: fanghao
 * @create: 2022/8/12
 **/
public class Offer_41MedianFinder {
    Queue<Integer> queue1, queue2;

    public Offer_41MedianFinder() {
        queue1 = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        queue2 = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(queue1.size() != queue2.size()) {
            queue1.add(num);
            queue2.add(queue1.poll());
        } else {
            queue2.add(num);
            queue1.add(queue2.poll());
        }
    }

    public double findMedian() {
        return queue1.size() != queue2.size() ? queue1.peek() : (queue1.peek() + queue2.peek()) / 2.0;
    }
}
