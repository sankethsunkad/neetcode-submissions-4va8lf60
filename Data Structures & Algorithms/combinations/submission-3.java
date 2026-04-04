class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        helper(new ArrayList<>(), 1, n, k);
        return res;
    }
     
    void helper(List<Integer> list, int m, int n, int k) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(m > n) return;
        helper(list, m + 1, n, k);
        
        list.add(m);
        helper(list, m + 1, n, k);
        list.remove(list.size() - 1);
    }   
}