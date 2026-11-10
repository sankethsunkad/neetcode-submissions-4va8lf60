class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int index = 0;
        while(index < nums.length) {
            if(nums[index] == 0){
                index++;
                continue;
            } 
            int count = 1;
            while((index + 1) < nums.length && nums[index] == nums[index + 1]) {
                count++;
                index++;
            }
            res = Math.max(res, count);
            index++;
        }   
        return res;
     }
}