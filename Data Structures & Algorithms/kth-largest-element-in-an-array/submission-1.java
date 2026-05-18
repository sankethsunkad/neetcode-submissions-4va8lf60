class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(int num : nums) {
            minQ.offer(num);
            if(minQ.size() > k) {
                minQ.poll();
            }
        }
        return minQ.peek();
    }
}
