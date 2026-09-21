class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(prices, 0, 1, dp);
    }

    int helper(int[] prices, int index, int canBuy, int[][] dp) {
        if(index == prices.length) {
            return 0;
        }
        if(dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }
        if(canBuy == 1) {
            dp[index][canBuy] = Math.max(helper(prices, index + 1, canBuy, dp), helper(prices, index + 1, 0, dp) - prices[index]);
            return dp[index][canBuy];
        }
        else {
            dp[index][canBuy] = Math.max(helper(prices, index + 1, canBuy, dp), helper(prices, index + 1, 1, dp) + prices[index]); 
            return dp[index][canBuy];
        }
    }
}