class Solution {
    public int missingNumber(int[] nums) {
        boolean[] check = new boolean[nums.length + 1];
        for(int num: nums) {
            check[num] = true;
        }

        for(int i = 0;i < check.length;i++) {
            if(!check[i]) return i;
        }
        return -1;
    }
}
