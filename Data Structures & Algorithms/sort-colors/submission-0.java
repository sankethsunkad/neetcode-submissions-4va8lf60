class Solution {
    public void sortColors(int[] nums) {
        int i = 0, k = nums.length - 1;
        
        int counter = 0;
        while(i < k) {
            if(nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k--] = temp;
            }
            else if(nums[i] == 0) {
                i++;
            }
            else {
                int j = i;
                while(j < nums.length && nums[j] != 0) {
                    j++;
                }
                if(j < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }
    }
}