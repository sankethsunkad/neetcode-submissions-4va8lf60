class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int runningSum = 0;
        for(int num : nums) {
            runningSum = runningSum + num;
            res = Math.max(res, runningSum);
            if(runningSum < 0) {
                runningSum = 0;
            }
        }
        return res;
    }
}
