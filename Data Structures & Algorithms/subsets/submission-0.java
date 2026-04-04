class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return res;
        addSubset(nums, 0, new ArrayList<>());
        return res;
    }

    void addSubset(int[] nums, int index, List<Integer> temp) {
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        addSubset(nums, index + 1, temp);
        temp.add(nums[index]);
        addSubset(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
        return;
    } 
}
