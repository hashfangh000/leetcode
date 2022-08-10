package Plan14days;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * @author fanghao on 2022/2/23
 */
public class Topic_74searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        for(int i = 0;i < row; i++){
            int left = 0, right = matrix[0].length - 1;

            while(left <= right){
                int mid = left + (right - left) / 2;
                if(matrix[i][mid] == target){
                    return true;
                }else if(matrix[i][mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Topic_74searchMatrix solution = new Topic_74searchMatrix();
        int[][] nums = {{1,3}};
        System.out.println(solution.searchMatrix(nums, 39));
    }
}