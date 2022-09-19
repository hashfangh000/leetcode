package leetcode_202209.hot100;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/combination-sum/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/19
 *
 * 先升序排序
 * 回溯剪枝操作，[2,3,6,7]
 * path[0] = 2,
 * path[1] = 2, 3, 6, 7
 * 当path[i] 大于target时，没有继续考虑的必要，因为数组是有序的,在回溯过程中，target为减去path[0...i-1]的值，这里需要注意
 *
 **/
public class Hot_39combinationSum {
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 1 && candidates[0] != target){
            return ans;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();
        backtracking(ans, path, candidates, target, 0);
        return ans;
    }

    private static void backtracking(List<List<Integer>> ans, Deque<Integer> path, int[] candidates, int target, int begin) {
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = begin; i < candidates.length; i++){
            if (target < candidates[i]){            //target剩下的值小于当前要添加的值，后面也就更添加不了
                return;
            }
            path.addLast(candidates[i]);
            backtracking(ans, path, candidates, target - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        combinationSum(candidates, 7);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
