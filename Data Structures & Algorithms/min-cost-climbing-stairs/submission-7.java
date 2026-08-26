class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) return 0;
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        
        int left = helper(cost, 0, dp);
        int right = helper(cost, 1, dp);

        return Math.min(left, right);
    }

    public int helper(int[] cost, int index, int[] dp) {
        if(index >= cost.length) return 0;
        if(dp[index] != -1) return dp[index];
        dp[index] = cost[index] + Math.min(helper(cost, index + 1, dp), helper(cost, index + 2, dp));
        return dp[index];
    }
}
