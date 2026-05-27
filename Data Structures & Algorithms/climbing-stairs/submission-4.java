class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i = 1;i <= n;i++) {
            if(i >= 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    int helper(int n, int[] dp) {
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }
}
