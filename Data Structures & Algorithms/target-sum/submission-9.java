class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target);
    }

    int helper(int[] nums, int index, int target) {
        if(index == nums.length) {
            if(target == 0) return 1;
            return 0;
        }
        return helper(nums, index + 1, target + nums[index]) + helper(nums, index + 1, target - nums[index]);
    }
}
