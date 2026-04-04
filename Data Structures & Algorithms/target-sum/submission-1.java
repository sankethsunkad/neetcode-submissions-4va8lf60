class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    int helper(int[] nums, int target, int index, int sum) {
        if(index == nums.length) {
            if(target == sum) return 1;
            return 0;
        }
        sum += nums[index];
        int res = helper(nums, target, index + 1, sum);
        sum = sum - (2 * nums[index]);
        res += helper(nums, target, index + 1, sum);
        return res;
    } 
}
