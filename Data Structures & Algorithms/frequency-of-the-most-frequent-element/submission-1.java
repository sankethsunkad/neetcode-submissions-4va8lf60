class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int currSum = 0;

        int res = 0;
        for(int i = 0;i < nums.length;i++) {
            if((i + 1) < nums.length && nums[i] == nums[i + 1]) {
                continue;
            }
            int right = i;
            currSum = nums[i];
            int left = i;
            int len = right - left + 1;
            while(left >= 0) {
                len = right - left + 1; 
                if(currSum + k >= nums[right] * len) {
                    res = Math.max(res, len);
                    left--;
                    if(left >= 0) {
                        currSum += nums[left];
                    }
                }
                else {
                    left = -1;
                }
            }
        }
        return res;
    }
}