class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        PriorityQueue<Long> maxQ = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for(int i = 0;i < nums1.length;i++) {
            for(int j = 0;j < nums2.length;j++) {
                maxQ.offer((long)nums1[i] * nums2[j]);
                if(maxQ.size() > k) maxQ.poll();
            }
        }
        return maxQ.peek();
    }
}