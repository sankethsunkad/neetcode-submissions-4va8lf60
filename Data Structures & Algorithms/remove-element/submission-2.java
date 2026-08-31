class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] == val) {
                int j = i + 1;
                while(j < nums.length && nums[j] == val) {
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

        int k = 0;
        while(k < nums.length && nums[k] != val) {
            k++;
        }
        return k;
    }
}