class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // for(int[] curr : dp) {
        //     Arrays.fill(curr, -1);
        // }
        dp[m - 1][n - 1] = 1;
        for(int i = m - 1;i >= 0;i--) {
            for(int j = n - 1;j >= 0;j--) {
                if(i == (m - 1) && j == (n - 1)) continue;
                if(i == (m - 1)) {
                    dp[i][j] = dp[i][j + 1];
                }
                else if(j == (n - 1)) {
                    dp[i][j] = dp[i + 1][j];
                }
                else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    int helper(int i, int j, int m, int n, int[][] dp) {
        if(i == (m - 1) && j == (n - 1)) return 1;
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = helper(i, j + 1, m, n, dp) + helper(i + 1, j, m, n, dp);
        return dp[i][j];
    }
}
