class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int res = dp[n - 1];
        for(int i = n - 2;i >= 0;i--) {
            dp[i] = 1;
            for(int j = i + 1;j < n;j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
        //return helper(nums, 0, -1);
    }

    int helper(int[] nums, int index, int previous) {
        if(index == nums.length) return 0;
        int res = helper(nums, index + 1, previous);

        if(previous == -1 || nums[index] > nums[previous]) {
            res = Math.max(res, 1 + helper(nums, index + 1, index));
        }
        return res;
    }
}
