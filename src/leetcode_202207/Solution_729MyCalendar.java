package leetcode_202207;

import java.util.*;

/**
 * @program: leetcode_202207
 * @description: https://leetcode.cn/problems/my-calendar-i/
 * @author: fanghao
 * @create: 2022/7/5 21:38
 */
public class Solution_729MyCalendar {
    List<int[]> list;
    public Solution_729MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : list) {
            int l = arr[0], r = arr[1];
            if(l < end && start < r){
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }

    public void bookTest(){
        int[][] num = {{10, 20}, {50, 60}, {10, 40},{5, 15},{5,10}};
        for (int i = 0; i < num.length; i++){
            int start = num[i][0];
            int end = num[i][1];
            for (int[] arr : list) {
                int l = arr[0], r = arr[1];
                if(l < end && start < r){
                    return;
                }
            }
            list.add(new int[]{start, end});
        }

    }
    public static void main(String[] args) {
        Solution_729MyCalendar obj = new Solution_729MyCalendar();
        obj.bookTest();
    }
}