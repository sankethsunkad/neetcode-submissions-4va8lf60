class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new HashSet<>(), new ArrayList<>());
        return res;
    }
    void helper(int[] nums, HashSet<Integer> set, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(!set.contains(i)) {
                set.add(i);
                list.add(nums[i]);
                helper(nums, set, list);
                set.remove(i);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}
