class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0;i < n;i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int res = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i < n;i++) {
            if(!visited[i]) {
                res++;
                helper(i, graph, visited);
            }
        }

        return res;
    }

    public void helper(int i, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        for(int curr : graph.get(i)) {
            if(!visited[curr]) {
                helper(curr, graph, visited);
            }
        }
    }
}
