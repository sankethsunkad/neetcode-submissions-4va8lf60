class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for(int i = 0;i < n;i++) {
            int curr = i + 1;
            if(dp[i]) {
                while(curr < n && curr <= (i + nums[i])) {
                    dp[curr] = true;
                    curr++;
                }
            }
        }
        return dp[n - 1];
    }
}
