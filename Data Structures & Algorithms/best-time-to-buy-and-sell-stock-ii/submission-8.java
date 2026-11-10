class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(prices, 0, 1);
    }

    int helper(int[] prices, int index, int canBuy) {
        if(index == prices.length) return 0;

        if(dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }        
        int res = helper(prices, index + 1, canBuy);
        if(canBuy == 1) {
            res = Math.max(res, -prices[index] + helper(prices, index + 1, 0));
        }
        else {
            res = Math.max(res, prices[index] + helper(prices, index + 1, 1));
        }
        dp[index][canBuy] = res;
        return res;
    }
}