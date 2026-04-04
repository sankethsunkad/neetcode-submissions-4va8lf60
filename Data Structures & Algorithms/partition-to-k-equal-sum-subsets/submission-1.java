class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length < k) return false;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if(sum % k != 0 || max > (sum / k)) return false;

        boolean[] visited = new boolean[nums.length];
        for(int i = 0;i < k;i++) {
            if(!helper(0, nums, visited, sum / k)) return false;
        }
        return true;
    }

    boolean helper(int index, int[] nums, boolean[] visited, int target) {
        if(target == 0) return true;
        if(index == nums.length || target < 0) return false;
        if(helper(index + 1, nums, visited, target)) return true;

        if(visited[index]) return false;

        visited[index] = true;
        if(helper(index + 1, nums, visited, target - nums[index])) return true;
        visited[index] = false;
        return false;    
    }
}