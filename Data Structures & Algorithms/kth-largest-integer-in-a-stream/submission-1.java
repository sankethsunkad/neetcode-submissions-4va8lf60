class KthLargest {
    PriorityQueue<Integer> minHeap;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        minHeap = new PriorityQueue<>();
        for(int i = 0;i < nums.length;i++) {
            minHeap.offer(nums[i]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > K) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
