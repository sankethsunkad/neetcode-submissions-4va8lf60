class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0;i < matrix.length;i++) {
            if(target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                return search(0, matrix[i].length - 1, matrix[i], target);
            }
        }
        return false;
    }

    boolean search(int start, int end, int[] nums, int target) {
        if(start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
            return true;
        }
        if(target < nums[mid]) {
            return search(start, mid - 1, nums, target);
        }
        return search(mid + 1, end, nums, target);
    }
}
