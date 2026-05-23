class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> parentPath = new HashSet<>();

        for(int i = 0;i < numCourses;i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] curr : prerequisites) {
            graph.get(curr[0]).add(curr[1]);
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0;i < numCourses;i++) {
            if(!visited[i]) {
                if(hasCycle(i, graph, numCourses, parentPath, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasCycle(int curr, HashMap<Integer, List<Integer>> graph, int num, HashSet<Integer> parentPath, boolean[] visited) {
        visited[curr] = true;
        parentPath.add(curr);
        for(int child : graph.get(curr)) {
            if(visited[child] && parentPath.contains(child)) return true;
            if(!visited[child]) {
                if(hasCycle(child, graph, num, parentPath, visited)) {
                    return true;
                }
            }
        }
        parentPath.remove(curr);
        return false;
    }
}
