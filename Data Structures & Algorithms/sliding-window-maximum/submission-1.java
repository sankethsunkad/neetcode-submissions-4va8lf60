class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        res[0] = findMax(nums, 0, k - 1);
        int count = 1;
        for(int i = k;i < nums.length;i++) {
            if(nums[i - k] == res[count - 1]) {
                res[count] = findMax(nums, i - k + 1, i);
            }
            else {
                res[count] = Math.max(res[count - 1], nums[i]);
            }
            count++;
        }
        return res;
    }
    public int findMax(int[] nums, int l, int r) {
        int max = nums[l];
        for(int i = l + 1;i <= r;i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
