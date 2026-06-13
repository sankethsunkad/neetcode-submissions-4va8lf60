class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(coins, amount, 0, dp);   
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
