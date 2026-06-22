class Solution {
    int n;
    int m;
    int[][] dir;
    public int longestIncreasingPath(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dp = new int[n][m];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        int res = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                res = Math.max(res, helper(i, j, visited, matrix, dp));
            }
        }
        return res;
    }

    int helper(int i, int j, boolean[][] visited, int[][] matrix, int[][] dp) {
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        visited[i][j] = true;
        int res = 1;
        for(int[] d : dir) {
            int row = i + d[0];
            int col = j + d[1];
            if(row < n && row >= 0 && col < m && col >= 0 && !visited[row][col] && matrix[row][col] > matrix[i][j]) {
                res = Math.max(res, 1 + helper(row, col, visited, matrix, dp));
            }
        }
        visited[i][j] = false;
        dp[i][j] = res;
        return dp[i][j];
    }
}
