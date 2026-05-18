class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    void helper(int[] nums, int index, List<Integer> list) {
        if(index == nums.length) {
            List<Integer> newList = new ArrayList<>(list);
            res.add(newList);
            return;
        }
        list.add(nums[index]);
        helper(nums, index + 1, list);
        list.remove(list.size() - 1);
        helper(nums, index + 1, list);
    }
}
