package leetcode_202205;

public class Topic_378kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right){
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, n, k)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int n, int k) {
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n){
            if (matrix[i][j] <= mid){
                count += i + 1;
                j++;
            }else{
                i--;
            }
        }
        return count >= k;
    }
}
