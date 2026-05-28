class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) return nums[0];
        int prev2 = nums[0];
        int prev = Math.max(prev2, nums[1]);
        for(int i = 2;i < nums.length;i++) {
            int res = Math.max(prev, nums[i] + prev2);
            prev2 = prev;
            prev = res;
        }
        return prev;
    }

}
