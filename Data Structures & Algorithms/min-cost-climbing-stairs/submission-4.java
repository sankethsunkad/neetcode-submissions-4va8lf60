class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0, dp), helper(cost, 1, dp));
    }

    int helper(int[] cost, int n, int[] dp) {
        if(n == cost.length) {
            return 0;
        }
        if(n > cost.length) {
            return Integer.MAX_VALUE;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        dp[n] = cost[n] + Math.min(helper(cost, n + 1, dp), helper(cost, n + 2, dp));
        return dp[n];
    }
}
