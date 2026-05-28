class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    int helper(int[] nums, int n, int[] dp) {
        if(n >= nums.length) return 0;
        if(dp[n] != -1) return dp[n];
        dp[n] = Math.max(nums[n] + helper(nums, n + 2, dp), helper(nums, n + 1, dp));
        return dp[n];
    }
}
