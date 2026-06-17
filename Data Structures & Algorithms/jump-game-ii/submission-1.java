class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int[] minJump = new int[nums.length];
        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;
        int n = nums.length;

        for(int i = 0;i < n;i++) {
            if(i <= maxReach) {
                maxReach = Math.max(maxReach, i + nums[i]);
                int j = i;
                while(j <= i + nums[i] && j < n) {
                    minJump[j] = Math.min(minJump[j], 1 + minJump[i]);
                    j++;
                } 
            }
        }
        return minJump[n - 1];
    }
}
