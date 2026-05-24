class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0;i < n;i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] curr : edges) {
            graph.get(curr[0]).add(curr[1]);
            graph.get(curr[1]).add(curr[0]);
        }

        boolean[] visited = new boolean[n];
        HashSet<Integer> path = new HashSet<>();

        if(hasCycle(0, graph, visited, -1, path)) return false;

        for(int i = 0;i < n;i++) {
            if(!visited[i]) return false;
        }
        return true;
    }

    boolean hasCycle(int i, HashMap<Integer, List<Integer>> graph, boolean[] visited, int parent, HashSet<Integer> path) {
        visited[i] = true;

        path.add(i);
        for(int curr : graph.get(i)) {
            if(visited[curr] && curr != parent && path.contains(curr)) {
                return true;
            }
            if(!visited[curr]) {
                if(hasCycle(curr, graph, visited, i, path)) return true;
            }
        }
        path.remove(i);
        return false;
    }
}
