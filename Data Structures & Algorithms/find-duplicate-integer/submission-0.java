class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] check = new boolean[nums.length];
        for(int i = 0;i < nums.length;i++) {
            if(!check[nums[i] - 1]) {
                check[nums[i] - 1] = true;
            }
            else {
                return nums[i];
            }
        }
        return -1;
    }
}
