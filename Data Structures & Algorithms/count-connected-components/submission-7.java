class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0;i < n;i++) {
            graph.put(i, new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for(int i = 0;i < n;i++) {
            if(!visited[i]) {
                count++;
                helper(visited, i, graph);
            }
        }
        return count;
    }

    void helper(boolean[] visited, int n, HashMap<Integer, List<Integer>> graph) {
        if(visited[n]) return;

        visited[n] = true;
        List<Integer> curr = graph.get(n);
        for(int i : curr) {
            if(!visited[i]) {
                helper(visited, i, graph);
            }
        }
    }
}
