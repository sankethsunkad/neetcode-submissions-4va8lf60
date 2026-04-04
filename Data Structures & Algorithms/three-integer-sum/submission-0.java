class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<List<Integer>> visited = new HashSet<>();
        for(int i = 0;i < nums.length;i++) {
            hm.put(nums[i], i);
        }
        for(int i = 0;i < nums.length;i++) {
            for(int j = i + 1;j < nums.length;j++) {
                int sum = nums[i] + nums[j];
                int diff = 0 - sum;
                if(hm.containsKey(diff) && hm.get(diff)!= i && hm.get(diff)!=j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[hm.get(diff)]);
                    Collections.sort(list);
                    if(!visited.contains(list)) {
                        res.add(list);
                        visited.add(list);
                    }
                }
            }
        }
        return res;
    }
}
