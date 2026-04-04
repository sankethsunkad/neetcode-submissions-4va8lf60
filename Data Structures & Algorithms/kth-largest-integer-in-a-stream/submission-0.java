class KthLargest {
    List<Integer> list = new ArrayList<>();
    int K;
    public KthLargest(int k, int[] nums) {
        for(int i = 0;i < nums.length;i++) {
            list.add(nums[i]);
        }
        K = k;
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size() - K);
    }
}
