public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }
        int target = (stoneSum + 1) / 2;
        int[][] dp = new int[stones.length][stoneSum];

        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }

        return dfs(0, 0, stones, stoneSum, target, dp);
    }

    private int dfs(int index, int total, int[] stones, int stoneSum, int target, int[][] dp) {
        if (total >= target || index == stones.length) {
            return Math.abs(total - (stoneSum - total));
        }

        if(dp[index][total] != -1) {
            return dp[index][total];
        }
        dp[index][total] =  Math.min(
            dfs(index + 1, total, stones, stoneSum, target, dp),
            dfs(index + 1, total + stones[index], stones, stoneSum, target, dp)
        );

        return dp[index][total];
    }
}