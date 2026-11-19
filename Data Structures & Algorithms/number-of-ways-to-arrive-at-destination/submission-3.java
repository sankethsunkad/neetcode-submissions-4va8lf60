class Solution {
    public int countPaths(int n, int[][] roads) {
        if(n == 1) return 1;
        int MOD = 1_000_000_007;

        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        long[] visited = new long[n];
        Arrays.fill(visited, Long.MAX_VALUE);

        for(int i = 0;i < n;i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int t = road[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        int res = 0;
        visited[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        q.offer(new long[]{0, 0});

        while(!q.isEmpty()) {
            
                long[] curr = q.poll();
                long cost = curr[1];
                int u = (int)curr[0];
                if(visited[u] < cost) {
                    continue;
                }

                for(int[] edge : graph.get(u)) {
                    int v = edge[0];
                    long time = edge[1];

                    if(cost + time < visited[v]) {
                        visited[v] = cost + time;
                        ways[v] = ways[u];
                        q.offer(new long[]{v, visited[v]});
                    }
                    else if(cost + time == visited[v]) {
                        ways[v] = (ways[v] + ways[u]) % MOD;
                    }
                }
            
        }
        return (int)ways[n - 1];
    }
}
