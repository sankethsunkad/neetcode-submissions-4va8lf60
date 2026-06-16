class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] jump = new boolean[n];
        jump[0] = true;

        for(int i = 0;i < n;i++) {
            if(jump[i]) {
                int target = i + nums[i];
                int j = i;
                while(j <= target && j < n) { 
                    jump[j] = true;
                    j++;
                }
                if(j < target) {
                    jump[n - 1] = true;
                    return true;
                }
            }
        }
        return jump[n - 1];
    }
}
