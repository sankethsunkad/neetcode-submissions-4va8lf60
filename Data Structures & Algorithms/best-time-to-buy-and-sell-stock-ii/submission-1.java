class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 0, dp);
    }

    int helper(int[] prices, int index, int holding, int[][] dp) {
        if (index == prices.length) return 0;

        if (dp[index][holding] != -1) return dp[index][holding];

        int res = helper(prices, index + 1, holding, dp);

        if (holding == 0) {
            res = Math.max(res, -prices[index] + helper(prices, index + 1, 1, dp));
        } else {
            res = Math.max(res, prices[index] + helper(prices, index + 1, 0, dp));
        }

        return dp[index][holding] = res;
    }
}