class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int prefixCount = 0;
        int postfixCount = nums.length - 1;
        int prefixSum = 1;
        int postfixSum = 1;
        for(int i = 0;i < nums.length;i++) {
            prefixSum = prefixSum * nums[prefixCount];
            prefix[prefixCount] = prefixSum;
            prefixCount++;
            postfixSum = postfixSum * nums[postfixCount];
            postfix[postfixCount] = postfixSum;
            postfixCount--;
        }
        int[] res = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            int pre, post;
            if((i - 1) < 0) {
                pre = 1;
            }
            else{
                pre = prefix[i - 1];
            }
            if((i + 1) == nums.length) {
                post = 1;
            }
            else{
                post = postfix[i + 1];
            }
            res[i] = pre * post;
        }
        return res;
    }
}  
