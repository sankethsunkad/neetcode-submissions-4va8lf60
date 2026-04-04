class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, PriorityQueue<int[]>> adj = new HashMap<>();
        for(int i = 0;i < n;i++) {
            adj.put(i, new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0])));
        }
        for(int[] curr : flights) {
            int u = curr[0];
            int v = curr[1];
            int w = curr[2];
            adj.get(u).offer(new int[]{w, v});
        }
        PriorityQueue<int[]> minHeap = adj.get(src);
        int res = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            res = Math.min(res, dfs(adj, curr[1], dst, 0, k, curr[0], visited));
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }

    int dfs(HashMap<Integer, PriorityQueue<int[]>> adj, int currDst, int dst, int currStops, int k, int wt, boolean[] visited) {
        if(currDst == dst && currStops <= k) return wt;
        currStops++;
        if(visited[currDst]) return Integer.MAX_VALUE;
        if(currStops > k) return Integer.MAX_VALUE;
        visited[currDst] = true;
        PriorityQueue<int[]> minHeap = adj.get(currDst);


        PriorityQueue<int[]> copyMin = new PriorityQueue<>(minHeap);

        int res = Integer.MAX_VALUE;

        while (!copyMin.isEmpty()) {
            int[] curr = copyMin.poll();
            res = Math.min(res,
                dfs(adj, curr[1], dst, currStops, k, wt + curr[0], visited)
            );
        }
    
        visited[currDst] = false;
        return res;
    }
    
}
