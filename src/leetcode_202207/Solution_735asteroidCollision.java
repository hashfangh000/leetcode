package leetcode_202207;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/asteroid-collision/
 * @author: fanghao
 * @create: 2022-07-13 12:53
 **/

public class Solution_735asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,2};
        Solution_735asteroidCollision solution = new Solution_735asteroidCollision();
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
    }
}
