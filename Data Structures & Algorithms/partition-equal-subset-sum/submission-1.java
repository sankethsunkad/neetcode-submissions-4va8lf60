class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int[][] dp = new int[nums.length][sum / 2 + 1];
        for(int[]curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(nums, 0, sum / 2, dp);
    }

    boolean helper(int[] nums, int index, int current, int[][] dp) {
        if(current == 0) return true;
        if(index == nums.length || current < 0) return false;
        if(dp[index][current] != -1) {
            if(dp[index][current] == 0) return false;
            return true;
        }
        boolean res = helper(nums, index + 1, current, dp);
        if(nums[index] <= current) {
            res = res || helper(nums, index + 1, current - nums[index], dp);
        }
        if(res == true) {
            dp[index][current] = 1;
        }
        else {
            dp[index][current] = 0;
        }
        return dp[index][current] == 1;
    }
}
