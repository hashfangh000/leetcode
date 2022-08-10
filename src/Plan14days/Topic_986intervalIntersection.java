package Plan14days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_986intervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int lenfirst = firstList.length, lensecond = secondList.length;
        //int lenmax = lenfirst > lensecond ? lenfirst : lensecond;
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < lenfirst && j < lensecond) {
            int left = firstList[i][0] > secondList[j][0] ? firstList[i][0] : secondList[j][0];
            int right = firstList[i][1] < secondList[j][1] ? firstList[i][1] : secondList[j][1];

            if (left <= right) {
                ans.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Topic_986intervalIntersection solution = new Topic_986intervalIntersection();
        int[][] firstList = {{0, 2},{5, 10}, {13,23}, {24,25}};
        int[][] secondList = {{1, 5},{8, 12}, {15,23}, {25,25}};
//        int[][] firstList = {{1, 3},{5, 9}};
//        int[][] secondList = {};
        int[][] ans = solution.intervalIntersection(firstList, secondList);
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j] + ",");
            }
            System.out.println();
        }
    }
}
