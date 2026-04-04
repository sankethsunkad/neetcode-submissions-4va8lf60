class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }
    
    void helper(int[] candidates, int target, int index, List<Integer> list) {
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(index == candidates.length || target < 0) return;

        list.add(candidates[index]);
        helper(candidates, target - candidates[index], index + 1, list);
        list.remove(list.size() - 1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        helper(candidates, target, index + 1, list);
        return;
    }
}
