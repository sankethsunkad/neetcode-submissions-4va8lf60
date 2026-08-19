class Solution {
    public int search(int[] nums, int target) {
        int index = helper(nums, 0, nums.length - 1);
        if(index == 0) {
            return search(nums, target, 0, nums.length - 1);
        }

        if(target >= nums[index] && target <= nums[nums.length - 1]) {
            return search(nums, target, index, nums.length - 1);
        }
        return search(nums, target, 0, index - 1);
    }

    int helper(int[] nums, int start, int end) {
        if(start >= end) return start;
        int mid = start + (end - start) / 2;
        if(nums[mid] > nums[end]) {
            return helper(nums, mid + 1, end);
        }
        return helper(nums, start, mid);
    }

    int search(int[] nums,int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
