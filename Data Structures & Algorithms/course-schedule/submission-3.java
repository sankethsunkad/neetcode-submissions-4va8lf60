class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> recPath = new HashSet<>();
        boolean[] visited = new boolean[numCourses];
        for(int i = 0;i < numCourses;i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] d:prerequisites) {
            graph.get(d[0]).add(d[1]);
        }
        for(int i = 0;i < numCourses;i++) {
            if(!visited[i] && checkCycle(i, graph, recPath, visited)) {
                return false;
            }
        }
        return true;
    }   

    boolean checkCycle(int index, HashMap<Integer, List<Integer>> graph, HashSet<Integer> recPath, boolean[] visited) {
        visited[index] = true;
        if(recPath.contains(index)) return true;
        if(graph.get(index).isEmpty()) return false;
        recPath.add(index);
        for(int v : graph.get(index)) {
            if(checkCycle(v, graph, recPath, visited)) return true;
        }
        recPath.remove(index);
        graph.put(index, new ArrayList<>());
        return false;
    }

}
