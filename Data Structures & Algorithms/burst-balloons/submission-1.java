class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        return helper(newNums);
    }

    int helper(int[] nums) {
        if(nums.length == 2) return 0;

        int res = 0;
        int n = nums.length;
        for(int i = 1;i < n - 1;i++) {
            int curr = nums[i] * nums[i - 1] * nums[i + 1];
            int[] newNums = new int[n - 1];
            for(int j = 0, k = 0;j < n;j++) {
                if(j != i) {
                    newNums[k++] = nums[j];
                }
            }
            curr += helper(newNums);
            res = Math.max(res, curr);
        }
        return res;
    }
}
