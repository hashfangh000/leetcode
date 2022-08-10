package leetcode_202206.linkedlist;

import java.util.Random;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/generate-random-point-in-a-circle/
 * @author: fanghao
 * @create: 2022-06-09 13:14
 **/

public class Topic_478Solution {
    double x1, y1, r;
    Random rand;
    public Topic_478Solution(double radius, double x_center, double y_center) {
        rand = new Random();
        x1 = x_center;
        y1 = y_center;
        r = radius;
    }

    public double[] randPoint() {
        while (true){
            double x = rand.nextDouble() * (2 * r) - r;
            double y = rand.nextDouble() * (2 * r) - r;
            if(x * x + y * y <= r * r){
                return new double[]{x1 + x, y1 + y};
            }
        }
    }
}
