package leetcode_202205;

public class Topic_668findKthNumber {
    public int findKthNumber(int m, int n, int k) {
//        int left = 1, right = m * n;
//        while (left < right) {
//            int x = left + (right - left) / 2;
//            int count = x / n * n;
//            for (int i = x / n + 1; i <= m; ++i) {
//                count += x / i;
//            }
//            if (count >= k) {
//                right = x;
//            } else {
//                left = x + 1;
//            }
//        }
//        return left;
        int left = 1, right = m * n;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if (check(mid, m, n, k)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mid, int m, int n, int k) {
        int i = m;
        int j = 1;
        int count = 0;
        while (i >= 1 && j <= n){
            if (i * j <= mid){
                count += i;
                j++;
            }else{
                i--;
            }
        }
        return count >= k;
    }

    public static void main(String[] args) {
        Topic_668findKthNumber solution = new Topic_668findKthNumber();
        System.out.println(solution.findKthNumber(3, 3,5));
    }
}
