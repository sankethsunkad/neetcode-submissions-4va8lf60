public class Solution {
    private int[] dp;
    private int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        // totalSum = 0;
        // for (int num : nums) totalSum += num;
        // if (Math.abs(target) > totalSum) return 0;
        // dp = new int[2 * totalSum + 1];

        // dp[totalSum] = 1;
        // // for (int i = 0; i < nums.length; i++) {
        // //     for (int j = 0; j < 2 * totalSum + 1; j++) {
        // //         dp[i][j] = Integer.MIN_VALUE;
        // //     }
        // // }
        // // return backtrack(0, 0, nums, target);
        // for (int i = 0; i < nums.length; i++) {
        //     int[] curr = new int[2 * totalSum + 1];
        //     for (int j = 0; j < 2 * totalSum + 1; j++) {
        //         if(dp[j] > 0) {
        //             if (j + nums[i] <= 2 * totalSum) {
        //                 curr[j + nums[i]] += dp[j];
        //             }
        //             if (j - nums[i] >= 0) {
        //                 curr[j - nums[i]] += dp[j];
        //             }
        //         }
        //     }
        //     dp = curr;
        // }
        // return dp[target + totalSum];
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for(int num : nums) {
            HashMap<Integer, Integer> curr = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry:dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                curr.put(total + num, curr.getOrDefault(total + num, 0) + count);
                curr.put(total - num, curr.getOrDefault(total - num, 0) + count);
            }
            dp = curr;
        }
        return dp.getOrDefault(target, 0);
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