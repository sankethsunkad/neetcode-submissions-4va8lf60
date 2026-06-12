public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return dfs(0, 1, prices, dp);
    }

    private int dfs(int i, int buying, int[] prices, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }
        if(dp[i][buying] != -1) return dp[i][buying];
        int cooldown = dfs(i + 1, buying, prices, dp);
        if (buying == 1) {
            int buy = dfs(i + 1, 0, prices, dp) - prices[i];
            dp[i][buying] = Math.max(buy, cooldown);
            return dp[i][buying];
        } else {
            int sell = dfs(i + 2, 1, prices, dp) + prices[i];
            dp[i][buying] = Math.max(sell, cooldown);
            return dp[i][buying];
        }
    }
}