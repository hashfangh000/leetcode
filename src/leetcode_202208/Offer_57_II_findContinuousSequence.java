package leetcode_202208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author: fanghao
 * @create: 2022/8/18
 **/
public class Offer_57_II_findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[] > list = new ArrayList<>();
        int l = target % 2 == 1 ? target / 2 + 1 : target / 2;
        for (int i = 1; i <= l; i++){
            int curSum = 0;
            for (int j = i; j <= l; j++){
                curSum += j;
                if (curSum == target){
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    list.add(res);
                    break;
                }else if(curSum > target){
                    break;
                }else{
                    continue;
                }
            }
        }
        return list.toArray(new int[list.size()][]);

    }

    public static void main(String[] args) {
        Offer_57_II_findContinuousSequence solution = new Offer_57_II_findContinuousSequence();
        int[][] ans = solution.findContinuousSequence(9);
        for (int[] a : ans){
            System.out.println(Arrays.toString(a));
        }
    }
}
