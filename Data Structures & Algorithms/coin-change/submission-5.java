class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        dp[0] = 0;
        for(int i = 0;i <= amount;i++) {
            if(dp[i] == null) continue;
            for(int coin : coins) {
                long next = (long) i + coin;
                if(next <= amount) {
                    int idx = (int) next;
                    if(dp[idx] == null) {
                        dp[idx] = dp[i] + 1;
                    }
                    else {
                        dp[idx] = Math.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }
        }
        return dp[amount] == null? -1 : dp[amount];
    }
}
