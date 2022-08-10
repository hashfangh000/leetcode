package leetcode_202206;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/koko-eating-bananas/
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * @author fanghao on 2022/6/7
 */
public class Topic_875minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high){
            int speed = low + (high - low) / 2;
            long time = getTime(piles, speed);
            if (time <= h){
                k = speed;
                high = speed;
            }else {
                low = speed + 1;
            }
        }
        return k;
    }

    private long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }

}