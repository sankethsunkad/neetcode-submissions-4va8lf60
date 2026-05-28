class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2;i < nums.length;i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }

    int helper(int[] nums, int n, int[] dp) {
        if(n >= nums.length) return 0;
        if(dp[n] != -1) return dp[n];
        dp[n] = Math.max(nums[n] + helper(nums, n + 2, dp), helper(nums, n + 1, dp));
        return dp[n];
    }
}
