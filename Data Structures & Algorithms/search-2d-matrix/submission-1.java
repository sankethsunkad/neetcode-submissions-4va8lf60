class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        int res = -1;
        while(l <= r) {
            int mid = l + ((r - l) / 2);
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                res = mid;
                break;
            }
            else if(target < matrix[mid][0]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        if(res == -1) return false;

        l = 0;
        r = matrix[res].length - 1;
        while(l <= r) {
            int mid = l + ((r - l) / 2); 
            if(matrix[res][mid] == target) {
                return true;
            }
            else if (matrix[res][mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}

