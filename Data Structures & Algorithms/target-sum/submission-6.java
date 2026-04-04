public class Solution {
    private int[] dp;
    private int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) totalSum += num;
        if (Math.abs(target) > totalSum) return 0;
        dp = new int[2 * totalSum + 1];

        dp[totalSum] = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < 2 * totalSum + 1; j++) {
        //         dp[i][j] = Integer.MIN_VALUE;
        //     }
        // }
        // return backtrack(0, 0, nums, target);
        for (int i = 0; i < nums.length; i++) {
            int[] curr = new int[2 * totalSum + 1];
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                if(dp[j] > 0) {
                    if (j + nums[i] <= 2 * totalSum) {
                        curr[j + nums[i]] += dp[j];
                    }
                    if (j - nums[i] >= 0) {
                        curr[j - nums[i]] += dp[j];
                    }
                }
            }
            dp = curr;
        }
        return dp[target + totalSum];
    }

    // private int backtrack(int i, int total, int[] nums, int target) {
    //     if (i == nums.length) {
    //         return total == target ? 1 : 0;
    //     }
    //     if (dp[i][total + totalSum] != Integer.MIN_VALUE) {
    //         return dp[i][total + totalSum];
    //     }
    //     dp[i][total + totalSum] = backtrack(i + 1, total + nums[i], nums, target) +
    //                               backtrack(i + 1, total - nums[i], nums, target);
    //     return dp[i][total + totalSum];
    // }
}