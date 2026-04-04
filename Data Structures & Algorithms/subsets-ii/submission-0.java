class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    void helper(int[] nums, int index, List<Integer> list) {
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[index]);
        helper(nums, index + 1, list);
        list.remove(list.size() - 1);

        while((index + 1) < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        helper(nums, index + 1, list);
        return;
    }
}
