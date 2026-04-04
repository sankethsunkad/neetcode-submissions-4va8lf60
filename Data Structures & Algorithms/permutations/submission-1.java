class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    void helper(int[] nums, boolean[] set, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(!set[i]) {
                set[i] = true;
                list.add(nums[i]);
                helper(nums, set, list);
                set[i] = false;
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}
