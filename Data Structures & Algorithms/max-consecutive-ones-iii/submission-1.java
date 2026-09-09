class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int n = nums.length;
        int high = 0;
        int res = 0;
        int count = 0;
        while(high < n) {
            if(nums[high] == 1) {
                high++;
            }
            else {
                count++;
                high++;
                while(count > k) {
                    if(nums[low] == 0) {
                        count--;
                    }
                    low++;
                } 
            }
            res = Math.max(res, (high - low));
        }
        return res;
    }
}