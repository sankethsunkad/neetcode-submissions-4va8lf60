class Solution {
    public boolean check(int[] nums) {
        int index = 0;
        boolean check = false;
        for(int i = 0;i < nums.length - 1;i++) {
            if(nums[i] > nums[i + 1]) {
                check = true;
                index = i;
                break;
            }
        }
        if(!check) return true;
        int count = 0;
        for(int i = (index + 1) % nums.length;count < nums.length - 1;i++) {
            i = i % nums.length;
            if(nums[i] > nums[(i + 1) % nums.length]) return false;
            count++;
        }
        return true;
    }
}