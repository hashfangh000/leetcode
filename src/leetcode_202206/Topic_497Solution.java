package leetcode_202206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 * @author: fanghao
 * @create: 2022-06-09 10:17
 *
 * 每一个点选取的概率要相等，根据面积判断，如3个矩形面积为 9, 12, 16；也表示分别有9, 12, 16个点选择，每个矩形被选中概率为9/37, 12/37, 16/37
 * 先计算所有矩形总面积
 **/

public class Topic_497Solution {
    Random rand;
    List<Integer> arr;
    int[][] rects;

    public Topic_497Solution(int[][] rects) {
        rand = new Random();
        arr = new ArrayList<Integer>();
        arr.add(0);
        this.rects = rects;
        for (int[] rect : rects) {
            int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
            arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
        }
    }

    public int[] pick() {
        //随机选取点k,
        int k = rand.nextInt(arr.get(arr.size() - 1));
        //二分查找点k在哪个矩形中，arr中第一个元素是0, k + 1
        int rectIndex = binarySearch(arr, k + 1) - 1;
        k -= arr.get(rectIndex);
        int[] rect = rects[rectIndex];
        int a = rect[0], b = rect[1], y = rect[3];
        int col = y - b + 1;
        int da = k / col;
        int db = k - col * da;
        return new int[]{a + da, b + db};
    }

    private int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = arr.get(mid);
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1},{2,2,4,6}};
        Topic_497Solution solution = new Topic_497Solution(rects);
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));

    }
}
