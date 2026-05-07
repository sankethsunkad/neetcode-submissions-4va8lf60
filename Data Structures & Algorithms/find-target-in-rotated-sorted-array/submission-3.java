class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int n = nums.length;
        int r = n - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        System.out.println(" mid = " + l);
        if(l == 0) {
            return helper(nums, 0, n - 1, target);
        }
        int mid = l - 1;
        l = 0;
        r = n - 1;
        if(target >= nums[l] && target <= nums[mid]) {
            return helper(nums, l, mid, target);
        }
        return helper(nums, mid + 1, r, target);
    }

    public int helper(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
