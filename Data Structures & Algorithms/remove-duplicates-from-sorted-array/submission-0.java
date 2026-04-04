class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++) {
            while((i + 1) < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            list.add(nums[i]);
        }
        int k = list.size();
        for(int i = 0;i < k;i++) {
            nums[i] = list.get(i);
        }
        return k;
    }
}