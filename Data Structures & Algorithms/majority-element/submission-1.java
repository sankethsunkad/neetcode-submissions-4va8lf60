class Solution {
    public int majorityElement(int[] nums) {
        int max = nums[0];
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }
        int[] count = new int[max + 1];
        int res = 0;
        int rescount = 0;
        for(int num : nums) {
            count[num]++;
            if(count[num] > rescount) {
                rescount = count[num];
                res = num;
            }
        }
        return res;
    }
}