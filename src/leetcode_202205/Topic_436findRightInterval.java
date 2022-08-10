package leetcode_202205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_436findRightInterval {
    public int[] findRightInterval(int[][] intervals) {
//        int m = intervals.length;
//        int[] res = new int[m];
//
//        for (int i = 0; i < m; i++){
//            int index = -1;
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < m; j++){
//                if (intervals[i][1] == intervals[j][0]){
//                    index = j;
//                    break;
//                }else if (intervals[i][1] < intervals[j][0]){
//                    if(min > intervals[j][0]){
//                        min = intervals[j][0];
//                        index = j;
//                    }
//                }
//            }
//            res[i] = index;
//        }
//        return res;
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++){
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, ((o1, o2) -> o1[0] - o2[0]));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]){
                    target = startIntervals[mid][1];
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }

    public static void main(String[] args) {
        Topic_436findRightInterval solution = new Topic_436findRightInterval();
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{1,4}, {2, 3}, {3, 4}})));
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{3,4}, {2, 3}, {1, 2}})));
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{1,2}, {2, 3}, {0 , 1}, {3, 4}})));
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{3,4}})));
    }
}
