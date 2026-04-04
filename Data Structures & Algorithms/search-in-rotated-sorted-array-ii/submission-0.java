class Solution {
    int target;
    public boolean search(int[] nums, int target) {
        this.target = target;
        int index = helper(nums);
        if(target > nums[nums.length - 1]) {
            return helper(nums, 0, index - 1);
        }
        return helper(nums, index, nums.length - 1);
    }

    public int helper(int[] nums) {
        for(int i = 0;i < nums.length - 1;i++) {
            if((i + 1) < nums.length && nums[i] > nums[i + 1]) {
                System.out.println(i + 1);
                return i + 1;
            }
        }
        return 0;
    }

    public boolean helper(int[] nums, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}