class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int res = 1;

        int inc = 1;
        int dec = 1;

        int prev = nums[0];
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] > prev) {
                inc++;
                dec = 1;
                res = Math.max(res, inc);
            }
            else if(nums[i] < prev) {
                dec++;
                inc = 1;
                res = Math.max(res, dec);
            }
            else {
                dec = 1;
                inc = 1;
            }
            prev = nums[i];
        }
        return res;
    }

}