class KthLargest {
    private PriorityQueue<Integer> minQueue;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minQueue = new PriorityQueue<>();
        for(int i = 0;i < nums.length;i++) {
           minQueue.offer(nums[i]);
           if(minQueue.size() > k) {
                minQueue.poll();
           } 
        }
    }
    
    public int add(int val) {
        minQueue.offer(val);
        if(minQueue.size() > k) {
            minQueue.poll();
        }
        return minQueue.peek();
    }
}
