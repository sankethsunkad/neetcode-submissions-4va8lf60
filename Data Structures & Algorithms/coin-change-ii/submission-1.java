class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0) return 0;
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(coins, 0, amount, dp);
    }

    int helper(int[] coins, int index, int amount, int[][] dp) {
        if(index >= coins.length) return 0;
        if(amount == 0) return 1;
        if(dp[index][amount] != -1) return dp[index][amount];
        int res = 0;
        if(coins[index] <= amount) {
            res = helper(coins, index + 1, amount, dp);
            res += helper(coins, index, amount - coins[index], dp);
        }
        dp[index][amount] = res;
        return dp[index][amount] ;
    }
}
