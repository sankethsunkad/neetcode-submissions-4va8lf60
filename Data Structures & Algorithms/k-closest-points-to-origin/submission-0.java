class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> ((b[1] * b[1] + b[0] * b[0]) - (a[1] * a[1] + a[0] * a[0])));
        for(int[] curr : points) {
            maxHeap.offer(curr);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int n = maxHeap.size();
        int[][] res = new int[n][2];
        for(int i = 0;i < n;i++) {
            int[] curr = maxHeap.poll();
            res[i][0] = curr[0];
            res[i][1] = curr[1];
        } 
        return res;
    }
}
