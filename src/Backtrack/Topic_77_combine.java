package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Topic_77_combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        backtracking(ans, current, 0, n, k);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> current, int begin, int n, int k) {
        if (current.size() == k){
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = begin; i < n; i++){
            current.add(i + 1);
            backtracking(ans, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Topic_77_combine solution = new Topic_77_combine();
        List<List<Integer>> ans = solution.combine(4, 3);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ,");
            }
            System.out.println();
        }
    }
}
