package leetcode_202207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/merge-intervals/
 * @author: fanghao
 * @create: 2022-07-06 13:23
 * 合并区间 结果为不重叠的区间
 **/

public class Solution_56merge {
    public int[][] merge(int[][] intervals) {
        int row = intervals.length;
        int i = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<int[]>();
        while(i < row){
            int l = intervals[i][0], r = intervals[i][1];
            if(res.size() == 0 || res.get(res.size() - 1)[1] < l){
                res.add(new int[]{l, r});
            }else{
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
            }
            i++;
        }
        return  res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution_56merge solution_56merge = new Solution_56merge();
        int[][] merge = solution_56merge.merge(new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
