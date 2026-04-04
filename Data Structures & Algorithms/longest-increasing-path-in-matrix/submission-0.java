class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        // for(int[] curr : dp) {
        //     Arrays.fill(curr, -1);
        // }
        int res = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                res = Math.max(res, helper(matrix, i, j, -1));
            }
        }
        return res;
    }

    int helper(int[][] matrix, int i, int j, int prev) {
        if(i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || matrix[i][j] <= prev) return 0;

        int val = matrix[i][j];
        int res = Math.max(helper(matrix, i + 1, j, val), helper(matrix, i - 1, j, val));
        res = Math.max(res, helper(matrix, i, j + 1, val));
        res = Math.max(res, helper(matrix, i, j - 1, val));
        return 1 + res;
    }
}
