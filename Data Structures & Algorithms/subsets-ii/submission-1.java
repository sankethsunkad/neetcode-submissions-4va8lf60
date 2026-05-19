class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>());
        return res;
    }

    void helper(int index, int[] nums, List<Integer> list) {
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        helper(index + 1, nums, list);
        list.remove(list.size() - 1);

        while((index + 1) < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        helper(index + 1, nums, list);
    }
}
