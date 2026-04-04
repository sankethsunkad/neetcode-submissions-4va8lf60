class Solution {
    public void rotate(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        k = k % n;
        while(i < k) {
            int last = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
            i++;
        }
    }
}