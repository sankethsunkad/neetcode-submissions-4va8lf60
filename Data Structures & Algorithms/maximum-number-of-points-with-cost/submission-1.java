class Solution {
    int n;
    int m;
    public long maxPoints(int[][] points) {
        n  = points.length;
        m = points[0].length;
        int[][] dp = new int[n][m];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        int res = 0;
        
        for(int i = 0;i < m;i++) {
            res = Math.max(res, helper(points, 0, i, dp));
        }
        return res;
    }

    int helper(int[][] points, int i, int j, int[][] dp) {
        if(i == (n - 1)) return points[i][j];
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = 0;

        for(int col = 0;col < m;col++) {
            res = Math.max(res, points[i][j] + helper(points, i + 1, col, dp) - Math.abs(j - col));
        }
        dp[i][j] = res;
        return res;
    }
}