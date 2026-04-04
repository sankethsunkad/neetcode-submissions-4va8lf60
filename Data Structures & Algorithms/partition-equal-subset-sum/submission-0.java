class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        return helper(nums, 0, sum / 2);
    }

    boolean helper(int[] nums, int index, int current) {
        if(current == 0) return true;
        if(index == nums.length || current < 0) return false;

        boolean res = helper(nums, index + 1, current);
        res = res || helper(nums, index + 1, current - nums[index]);
        return res;
    }
}
