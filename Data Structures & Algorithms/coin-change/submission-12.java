class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        Arrays.sort(coins);
        for (int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - 1 - i];
            coins[coins.length - 1 - i] = temp;
        }
        int res = helper(coins, amount, 0, dp);
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }

    int helper(int[] coins, int amount, int count, int[] dp) {
        if(amount < 0) return Integer.MAX_VALUE;
        if(dp[amount] != -2) return dp[amount];
        if(amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int sub = Math.min(res, helper(coins, amount - coin, count + 1, dp));
            if(sub != Integer.MAX_VALUE) {
                res = Math.min(res, 1 + sub);
            }
        }
        dp[amount] = res;
        return dp[amount];
    }
}
