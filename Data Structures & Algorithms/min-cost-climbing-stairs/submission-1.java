class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int[] dp = new int[cost.length];
        // for(int i = 0;i < cost.length;i++) {
        //     dp[i] = -1;
        // }
        // if(cost.length == 1) {
        //     return cost[0];
        // }
        // return Math.min(minCostClimbingStairs(cost, dp, 0), minCostClimbingStairs(cost, dp, 1));
        if(cost.length == 1) {
             return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int prev = dp[1];
        int prev2 = dp[0];
        for(int i = 2;i < cost.length;i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
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
