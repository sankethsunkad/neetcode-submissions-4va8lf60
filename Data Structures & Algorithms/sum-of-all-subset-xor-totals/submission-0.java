class Solution {
    public int subsetXORSum(int[] nums) {
        int[] temp = new int[nums.length];
        Arrays.fill(temp, 0);
        return helper(nums, 0, temp);
    }

    int helper(int[] nums, int index, int[] curr) {
        if(index == nums.length) {
            int res = 0;
            for(int i = 0;i < nums.length;i++) {
                res = res ^ curr[i];
            }
            return res;
        }
        int left = helper(nums, index + 1, curr);

        curr[index] = nums[index];
        int right = helper(nums, index + 1, curr);
        curr[index] = 0;
        return left + right;
    }
}