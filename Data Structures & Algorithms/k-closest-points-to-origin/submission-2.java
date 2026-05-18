class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a, b) -> ((b[1] * b[1] + b[0] * b[0]) - (a[1] * a[1] + a[0] * a[0])));
        for(int[] point : points) {
            maxQueue.offer(point);
            if(maxQueue.size() > k) {
                maxQueue.poll();
            }
        }
        int n = maxQueue.size();
        int[][] res = new int[n][2];

        for(int i = 0;i < n;i++) {
            res[i] = maxQueue.poll();
        }
        return res;
    }
}
