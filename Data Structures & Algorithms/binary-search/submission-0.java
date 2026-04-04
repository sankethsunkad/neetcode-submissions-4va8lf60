class Solution {
    public int search(int[] nums, int target) {
        return search(0, nums.length - 1, nums, target); 
    }

    int search(int start, int end, int[] nums, int target) {
        if(start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        if(target < nums[mid]) {
            return search(start, mid - 1, nums, target);
        }
        return search(mid + 1, end, nums, target);
    }

}
