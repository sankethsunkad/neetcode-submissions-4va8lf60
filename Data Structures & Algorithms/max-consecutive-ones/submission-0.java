class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;

        int index = 0;
        while(index < nums.length) {
            if(nums[index] == 0) {
                index++;
                continue;
            }
            int curr = 0;
            while(index < nums.length && nums[index] == 1) {
                index++;
                curr++;
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}