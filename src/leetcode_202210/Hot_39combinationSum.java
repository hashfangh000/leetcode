package leetcode_202210;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/combination-sum/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/10/27
 * 给无重复的整数数组candidates 和一个目标整数target，找出数据中可以使数字和为目标数target的所有不同组合，
 * candidates中的同一个数字可以无限制重复被选取
 * candidates：2, 3, 6, 7 target = 7
 * [[2,2,3],[7]
 **/
public class Hot_39combinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if(target < candidates[0]){
            return res;
        }

        Deque<Integer> path = new LinkedList<>();
        backtracking(candidates, res, path, target, 0);
        return res;
    }


    private static void backtracking(int[] candidates, List<List<Integer>> res, Deque<Integer> path, int target, int begin) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++){            //begin 调整 当前位置为i， 下一个位置为 j， 且j >= i，
            if (target < candidates[i]){
                return;
            }
            path.addLast(candidates[i]);
            backtracking(candidates, res, path, target - candidates[i], i);     //从我开始往后选，可以选我自己
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        combinationSum(candidates, 7);
    }
}
