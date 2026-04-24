class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int leftCounter = 0;
        int rightCounter = 0;

        int[] res = new int[nums.length];
        int i = 0;
        for(i = 1;i < nums.length;i++) {
            if(nums[i] == 0) {
                rightCounter++;
            }
            else {
                right = right * nums[i];
            }
        }
        i = 0;
        while(i < nums.length) {
            if(leftCounter > 0 || rightCounter > 0) {
                res[i] = 0;
            }
            else {
                res[i] = left * right;
            }
            if(nums[i] == 0) {
                leftCounter++;
            }
            else {
                left = left * nums[i];
            }
            if((i + 1) < nums.length) {
                if(nums[i + 1] == 0) {
                    rightCounter--;
                }
                else {                    
                    right = right / nums[i + 1];
                }
            }
            i++;
        }
        return res;
    }
}  
