package leetcode_202207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/minimum-absolute-difference/
 * @author: fanghao
 * @create: 2022-07-04 10:35
 **/

public class Solution_1200minimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int min_abs = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            int dis = arr[i+1] - arr[i];
            if(dis < min_abs){
                min_abs = dis;
                ans.clear();
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i + 1]);
                ans.add(cur);
            }else if(dis == min_abs){
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i + 1]);
                ans.add(cur);
            }
        }
        return ans;
    }
}
