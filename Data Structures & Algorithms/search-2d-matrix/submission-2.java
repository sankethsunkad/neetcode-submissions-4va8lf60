class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]){
                return helper(matrix, mid, target);
            }
            if(target < matrix[mid][0]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }   
        return false;
    }

    boolean helper(int[][] matrix,int n, int target) {
        int l = 0;
        int r = matrix[0].length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target == matrix[n][mid]) {
                return true;
            }
            if(target < matrix[n][mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}
