class Solution {
    Integer[][][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n + 1][k + 1][target + 1];
        helper(n, k, target);
        if(dp[n][k][target] ==  null) return 0;
        return dp[n][k][target];
    }

    int helper(int n, int k, int target) {
        if(target < 0 || n < 0) return 0;
        if(target == 0 && n == 0) return 1;
        if(n == 0) return 0;

        if(dp[n][k][target] != null) {
            return dp[n][k][target];
        }
        int res = 0;
        for(int i = 1; i<= k;i++) {
            res += helper(n - 1, k, target - i);
            res = res % 1000000007;
        }
        dp[n][k][target] = res % 1000000007;
        return res;
    }
}
