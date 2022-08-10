package leetcode_202205;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
class Tpoic_933RecentCounter {
    Queue<Integer> queue;
    public Tpoic_933RecentCounter() {
        queue = new ArrayDeque<>();
    }
    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000){
            queue.poll();
        }
        return queue.size();
    }
}
