class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        int pivot = start;
        if(target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return BS(nums, pivot, nums.length - 1, target);
        }
        else {
            return BS(nums, 0, pivot - 1, target);
        }
    }
    int BS(int[] nums, int start, int end, int target) {
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target) {
            return BS(nums, start, mid - 1, target);
        }
        return BS(nums, mid + 1, end, target);
    }
}
