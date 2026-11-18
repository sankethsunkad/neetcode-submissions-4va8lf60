class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    int helper(int[] cost, int index) {
        if(index >= cost.length) return 0;
        if(dp[index] != -1) return dp[index];
        int res = 0;
        int stepOne = helper(cost, index + 1) + cost[index];
        int stepTwo = helper(cost, index + 2) + cost[index];
        dp[index] = Math.min(stepOne, stepTwo);
        return dp[index];
    }
}
