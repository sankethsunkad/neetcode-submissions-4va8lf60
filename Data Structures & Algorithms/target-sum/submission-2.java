class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> hm = new HashMap<>();
        return helper(nums, target, 0, 0, hm);
    }

    int helper(int[] nums, int target, int index, int sum, HashMap<String, Integer> dp) {
        if(index == nums.length) {
            if(target == sum) return 1;
            return 0;
        }
        
        String key = index + "," + sum;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        sum += nums[index];
        int res = helper(nums, target, index + 1, sum, dp);
        sum = sum - (2 * nums[index]);
        res += helper(nums, target, index + 1, sum, dp);
        dp.put(key, res);
        return dp.get(key);
    } 
}
