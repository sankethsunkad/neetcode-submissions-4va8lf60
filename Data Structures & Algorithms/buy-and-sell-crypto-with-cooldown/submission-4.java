class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(0, prices, 1, dp);
    }

    int helper(int i, int[] prices, int buy, int[][] dp) {
        if(i >= prices.length) {
            return 0;
        }

        if(dp[i][buy] != -1) {
            return dp[i][buy];
        }
        int cool = helper(i + 1, prices, buy, dp);

        if(buy == 1) {
            int second = helper(i + 1, prices, 0, dp) - prices[i];
            dp[i][buy] = Math.max(second, cool);
        }
        else {
            int second = helper(i + 2, prices, 1, dp) + prices[i];
            dp[i][buy] = Math.max(second, cool);
        }  
        return dp[i][buy];
    }
}
