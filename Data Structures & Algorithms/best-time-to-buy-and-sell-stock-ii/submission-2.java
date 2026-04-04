class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 0, dp);
    }

    int helper(int[] prices, int index, int price, int[][] dp) {
        if(index == prices.length) return 0;

        if(price != 0 && dp[index][1] != -1) {
            return dp[index][1];
        }

        if(price == 0 && dp[index][0] != -1) {
            return dp[index][0];
        }
        int res = helper(prices, index + 1, price, dp);

        if(price == 0) {
            res = Math.max(res, -prices[index] + helper(prices, index + 1, 1, dp));
            dp[index][0] = res;;
        }
        else {
            res = Math.max(res, prices[index] + helper(prices, index + 1, 0, dp));
            dp[index][1] = res;
        }
        return res;
    }
}