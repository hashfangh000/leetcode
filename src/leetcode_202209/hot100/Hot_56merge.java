package leetcode_202209.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/merge-intervals/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/23
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 将有重叠的部分 合并为一个区间
 * [1,3]-[2,6]->[1,6];
 * [1,4]-[4,5]->[1,5]
 *
 * 对intervals按照intervals[i][0]进行排序
 **/
public class Hot_56merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int row = intervals.length;
        int i = 0;
        List<int[]> res = new ArrayList<int[]>();
        while(i < row){         //每一行遍历
            int l = intervals[i][0], r = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l){
                res.add(new int[]{l, r});
            }else{
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
            }
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
