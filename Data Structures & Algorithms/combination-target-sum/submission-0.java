class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums.length == 0) return res;
        helper(nums, 0, 0, target, new ArrayList<>());
        return res;
    }

    void helper(int[] nums, int index, int currSum, int target, List<Integer> helperList) {
        if(currSum > target) return;
        if(index == nums.length || currSum == target) {
            if(currSum == target) res.add(new ArrayList<>(helperList));
            return;
        }
        
        currSum = currSum + nums[index];
        helperList.add(nums[index]);
        helper(nums, index, currSum, target, helperList);
        currSum = currSum - nums[index];
        helperList.remove(helperList.size() - 1);
     
        helper(nums, index + 1, currSum, target, helperList);
    
        return;
    }
}



