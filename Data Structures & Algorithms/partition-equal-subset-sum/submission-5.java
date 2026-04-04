class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[sum / 2] = true;

        for (int num : nums) {
            boolean[] curr = new boolean[sum / 2 + 1];
            for (int i = sum / 2; i >= 0; i--) {
                if (dp[i]) {
                    curr[i] = true;
                    if(i - num >= 0) {
                        curr[i - num] = true;
                    }
                }
            }
            dp = curr;
        }
        return dp[0];
    }
}
