class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    void helper(int[] nums, boolean[] check, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i < nums.length;i++) {
            if(!check[i]) {
                list.add(nums[i]);
                check[i] = true;
                helper(nums, check, list);
                check[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
