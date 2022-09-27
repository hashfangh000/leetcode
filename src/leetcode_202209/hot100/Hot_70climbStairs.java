package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/climbing-stairs/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/27
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 **/
public class Hot_70climbStairs {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int f1 = 1;
        int f2 = 2;

        // 1, 1, 2, 3, 4, 5
        // 1, 1, 2, 3, 5, 8...
        for (int i = 3; i <= n; i++){
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
