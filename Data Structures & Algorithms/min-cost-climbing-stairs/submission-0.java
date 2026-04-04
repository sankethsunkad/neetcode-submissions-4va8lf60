class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for(int i = 0;i < cost.length;i++) {
            dp[i] = -1;
        }
        if(cost.length == 1) {
            return cost[0];
        }
        return Math.min(minCostClimbingStairs(cost, dp, 0), minCostClimbingStairs(cost, dp, 1));
    }

    public int minCostClimbingStairs(int[] cost,int[] dp, int index) {
        if(index >= cost.length) {
            return 0;
        }
        if(dp[index] != -1) {
            return dp[index];
        }
        int res = cost[index] + Math.min(minCostClimbingStairs(cost, dp, index + 1), minCostClimbingStairs(cost, dp, index + 2));
        dp[index] = res;
        return res;
    }
}
