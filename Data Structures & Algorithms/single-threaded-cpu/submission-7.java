class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i = 0;i < tasks.length;i++) {
            q.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }

        int i = 0;
        int[] res = new int[tasks.length];
        
        if(q.isEmpty()) {
            return res;
        }
        int time = q.peek()[0];

        PriorityQueue<int[]> minQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        while(!q.isEmpty() || !minQ.isEmpty()) {        
            while(!q.isEmpty() && q.peek()[0] <= time) {
                minQ.offer(q.poll());
            }

            if(!minQ.isEmpty()) {
                int[] curr = minQ.poll();
                time = time + curr[1];
                res[i] = curr[2];
                i++;
            }
            else {
                time = q.peek()[0];
            }
        }
        return res;
    }
}