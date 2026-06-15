class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0;i < n;i++) {
            dp[i][0] = 1;
        }
        
        for(int i = n - 1;i >= 0;i--) {
            for(int a = 0;a <= amount;a++) {
                if (a >= coins[i]) {
                    dp[i][a] = dp[i + 1][a];
                    dp[i][a] += dp[i][a - coins[i]];
                }
            }
        }
        
        return dp[0][amount];
        //return helper(coins, amount, 0, dp);   
    }

    int helper(int[] coins, int amount, int index, int[][] dp) {
        if(amount == 0) return 1;
        if(index >= coins.length) return 0;
        if(dp[index][amount] != -1) {
            return dp[index][amount];
        }
        
        int res = 0;
        if(amount >= coins[index]) {
            res += helper(coins, amount, index + 1, dp);
            res += helper(coins, amount - coins[index], index, dp);
        }
        dp[index][amount] = res;
        return dp[index][amount];
    }
}
