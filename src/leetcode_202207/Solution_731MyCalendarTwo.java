package leetcode_202207;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/my-calendar-ii/
 * @author: fanghao
 * @create: 2022-07-19 20:08
 **/

public class Solution_731MyCalendarTwo {
    List<int[]> list;
    List<int[]> overlaps;
    public Solution_731MyCalendarTwo() {
        list = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if(l < end && start < r){
                return false;
            }
        }
        for (int[] arr : list){
            int l = arr[0], r = arr[1];
            if(l < end && start < r){
                overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}
