class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n - 1; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        int case1 = prev1;

        prev2 = nums[1];
        prev1 = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        int case2 = prev1;

        return Math.max(case1, case2);
    }
}
