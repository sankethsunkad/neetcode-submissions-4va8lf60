class Solution {
    List<List<Integer>> res;
    HashSet<List<Integer>> hashSet;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        hashSet = new HashSet<>();
        Arrays.sort(nums);
        this.target = target;
        helper(nums, 0, 0, new ArrayList<>());
        return res;
    }

    void helper(int[] nums, int index, int sum, List<Integer> list) {
        if(sum == target) {
            if(!hashSet.contains(list)) {
                List<Integer> newList = new ArrayList<>(list);
                res.add(newList);
                hashSet.add(newList);
            }
            return;
        }
        if(index == nums.length || sum > target) {
            return;
        }

        helper(nums, index + 1, sum, list);

        sum = sum + nums[index];
        list.add(nums[index]);
        helper(nums, index, sum, list);

        sum = sum - nums[index];
        list.remove(list.size() - 1);

        while((index + 1) < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        
        sum = sum + nums[index];
        list.add(nums[index]);
        helper(nums, index + 1, sum, list);
        sum = sum - nums[index];
        list.remove(list.size() - 1);
    }
}
