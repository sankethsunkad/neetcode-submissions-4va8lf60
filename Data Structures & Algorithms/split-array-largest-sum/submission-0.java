class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int res = sum;

        while (max <= sum) {
            int mid = max + (sum - max) / 2;

            int parts = helper(nums, mid);

            if (parts <= k) {
                res = mid;
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }

        return res;
    }

    int helper(int[] nums, int target) {
        int count = 1;
        int curr = 0;

        for (int num : nums) {
            if (curr + num > target) {
                count++;
                curr = num;
            } else {
                curr += num;
            }
        }

        return count;
    }
}