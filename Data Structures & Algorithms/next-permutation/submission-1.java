class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = n - 1;
        boolean found = false;
        int index = j - 1;

        while(j > 0) {
            if(nums[j - 1] < nums[j]) {
                found = true;
                index = j - 1;
                break;
            }
            j--;
        }
        if(!found) {
            Arrays.sort(nums);
            return;
        }

        int i = index + 1;
        int swap = i;
        i++;
        while(i < n) {
            if(nums[i] > nums[index] && nums[i] < nums[swap]) {
                swap = i;
            }
            i++;
        }

        int temp = nums[swap];
        nums[swap] = nums[index];
        nums[index] = temp;

        Arrays.sort(nums, index + 1, n);
        return;
    }
}