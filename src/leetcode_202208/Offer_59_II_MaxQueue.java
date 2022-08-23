package leetcode_202208;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author: fanghao
 * @create: 2022/8/22
 **/
public class Offer_59_II_MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public Offer_59_II_MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
