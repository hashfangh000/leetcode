package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author: fanghao
 * @create: 2022/8/9
 **/
public class Offer_13movingCount {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return DFS(0, 0, 0, 0);
    }

    private int DFS(int i, int j, int si, int sj) {

        if(i >= m || j >= n || k < si + sj || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        //
        return 1 + DFS(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + DFS(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    public static void main(String[] args) {
        Offer_13movingCount solution = new Offer_13movingCount();
        System.out.println(solution.movingCount(16,8,4));
    }
}
