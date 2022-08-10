package leetcode_202205;

import java.util.Arrays;

public class Tpoic_453minMoves {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

    public static void main(String[] args) {
        Tpoic_453minMoves solution = new Tpoic_453minMoves();
        System.out.println(solution.minMoves(new int[]{1, 0, 0, 8, 6}));
    }
}
