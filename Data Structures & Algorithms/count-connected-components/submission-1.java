class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        for(int i = 0;i < n;i++) {
            graph.put(i, new HashSet<>());
        }

        for(int i = 0;i < edges.length;i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];

        int res = 0;
        for(int i = 0;i < n;i++) {
            if(!visited[i]) {
                dfs(i, graph, visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int index, HashMap<Integer, HashSet<Integer>> graph, boolean[] visited) {
        visited[index] = true;
        for(int i : graph.get(index)) {
            if(!visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }
}
