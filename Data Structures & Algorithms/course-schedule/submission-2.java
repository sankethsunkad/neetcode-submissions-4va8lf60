class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0;i < numCourses;i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] d:prerequisites) {
            graph.get(d[0]).add(d[1]);
        }

        for(int i = 0;i < numCourses;i++) {
            if(checkCycle(i)) {
                return false;
            }
        }
        return true;
    }   

    boolean checkCycle(int index) {
        if(visited.contains(index)) return true;
        if(graph.get(index).isEmpty()) return false;
        visited.add(index);
        for(int v : graph.get(index)) {
            if(checkCycle(v)) return true;
        }
        visited.remove(index);
        graph.put(index, new ArrayList<>());
        return false;
    }


}
