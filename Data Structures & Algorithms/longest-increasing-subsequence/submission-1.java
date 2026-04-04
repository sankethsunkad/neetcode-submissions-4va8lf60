class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, -1);
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
