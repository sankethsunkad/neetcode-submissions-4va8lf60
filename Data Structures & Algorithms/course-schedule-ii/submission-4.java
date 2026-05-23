class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> parentPath = new HashSet<>();
        HashMap<Integer, List<Integer>> hasCycleGraph = new HashMap<>();

        for(int i = 0;i < numCourses;i++) {
            graph.put(i, new ArrayList<>());
            hasCycleGraph.put(i, new ArrayList<>());
        }

        int[] degree = new int[numCourses];
        for(int[] curr : prerequisites) {
            hasCycleGraph.get(curr[0]).add(curr[1]);
            graph.get(curr[1]).add(curr[0]);
            degree[curr[0]]++;
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0;i < numCourses;i++) {
            if(!visited[i]) {
                if(hasCycle(i, hasCycleGraph, numCourses, parentPath, visited)) {
                    return new int[0];
                }
            }
        }
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < numCourses;i++) {
            if(degree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            res[count++] = curr;
            for(int path : graph.get(curr)) {
                degree[path]--;
                if(degree[path] == 0) {
                    q.offer(path);
                }
            }
        }
        if(count != numCourses) {
            return new int[0];
        }
        return res;
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
