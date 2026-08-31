class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> edges = new HashMap<>();

        for(int i = 0;i < n;i++) {
            edges.put(i, new ArrayList<>());
        }
        for(int[] time : times) {
            int u = time[0] - 1;
            int v =  time[1] - 1;
            int t = time[2];
            edges.get(u).add(new int[]{u, v, t});
        }

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k - 1] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int[] curr : edges.get(k - 1)) {
            queue.offer(curr);
        }
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int v =  curr[1];
            int t = curr[2];

            if(res[u] + t < res[v]) {
                res[v] = res[u] + t;
                for(int[] currEdge : edges.get(v)) {
                    queue.offer(currEdge);
                }
            }
        }

        int returnRes = 0;
        for(int i = 0;i < n;i++) {
            if(res[i] == Integer.MAX_VALUE) return -1;
            returnRes = Math.max(returnRes, res[i]);
        }
        return returnRes;
    }
}
