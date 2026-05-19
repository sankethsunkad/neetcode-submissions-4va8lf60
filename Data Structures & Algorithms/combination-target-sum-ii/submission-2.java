class Solution {
    List<List<Integer>> res;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        this.target = target;
        helper(0, candidates, 0, new ArrayList<>());
        return res;
    }

    void helper(int index, int[] candidates, int sum, List<Integer> list) {
        if(sum == target) {
            List<Integer> newList = new ArrayList<>(list);
            res.add(newList);
            return;
        }
        if(sum > target || index >= candidates.length) {
            return;
        }

        sum = sum + candidates[index];
        list.add(candidates[index]);
        helper(index + 1, candidates, sum, list);

        sum = sum - candidates[index];
        list.remove(list.size() - 1);

        while((index + 1) < candidates.length && candidates[index + 1] == candidates[index]) {
            index++;
        }
        helper(index + 1, candidates, sum, list);
    }
}
