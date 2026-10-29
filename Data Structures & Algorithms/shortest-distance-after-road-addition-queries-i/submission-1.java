class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] dist = new int[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0;i < n;i++) {
            dist[i] = i;
            graph.put(i, new ArrayList<>());
            if(i != n - 1) graph.get(i).add(i + 1);
        }

        int[] res = new int[queries.length];
        int count = 0;

        for(int[] query : queries) {
            int u = query[0];
            int v = query[1];
            graph.get(u).add(v);
            
            if(dist[v] > (1 + dist[u])) {
                dist[v] = 1 + dist[u];
                dfs(v, dist, graph);
            }
            res[count] = dist[n - 1];
            count++;
        }
        return res;
    }

    void dfs(int u, int[] dist, HashMap<Integer, List<Integer>> graph) {
        for(int curr : graph.get(u)) {
            if(dist[curr] > 1 + dist[u]) {
                dist[curr] = 1 + dist[u];
                dfs(curr, dist, graph);
            }
        }
    }
}
