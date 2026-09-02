class Solution {
    public int removeDuplicates(int[] nums) {
        int[] res = new int[nums.length];

        int j = 0;
        for(int i = 0;i < nums.length;i++) {
            if((i + 1) < nums.length && nums[i] == nums[i + 1]) {
                res[j] = nums[i];
                j++;
                i++;
                res[j] = nums[i];
                j++;
                while((i + 1) < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            else {
                res[j] = nums[i];
                j++;
            }
        }

        for(int i = 0;i < j;i++) {
            nums[i] = res[i];
        }
        return j;
    }
}