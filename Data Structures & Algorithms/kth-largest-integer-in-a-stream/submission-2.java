class KthLargest {
    PriorityQueue<Integer> minQueue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minQueue = new PriorityQueue<>((a, b) -> a - b);
        for(int i = 0;i < nums.length;i++) {
           minQueue.add(nums[i]);
           if(minQueue.size() > k) {
            minQueue.poll();
           } 
        }
    }
    
    public int add(int val) {
        minQueue.add(val);
        if(minQueue.size() > k) {
            minQueue.poll();
        }
        return minQueue.peek();
    }
}
