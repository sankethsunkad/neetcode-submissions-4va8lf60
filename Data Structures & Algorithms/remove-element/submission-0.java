class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int count = 0;
        while(i < nums.length) {
            if(nums[i] == val) {
                int j = i + 1;
                while(j < nums.length) {
                    if(nums[j] != val) {
                        break;
                    }
                    j++;
                }
                if(j < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            i++;
        }
        for(int num : nums) {
            if(num == val) count++;
        }
        return nums.length - count;
    }
}