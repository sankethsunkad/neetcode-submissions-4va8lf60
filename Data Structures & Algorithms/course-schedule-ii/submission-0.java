class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i =0;i < numCourses;i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int d[] : prerequisites) {
            graph.get(d[0]).add(d[1]);
        }

        int[] res = new int[numCourses];

        boolean[] visited = new boolean[numCourses];

        for(int i = 0;i < numCourses;i++) {
            if(!visited[i]) {
                if(hasCycle(i, graph, visited, new boolean[numCourses])) {
                    return new int[0];
                }
            }
        }

        for(int i = 0;i < numCourses;i++) {
            visited[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < numCourses;i++) {
            if(!visited[i]) {
                helper(i, graph, visited, queue);
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }

    void helper(int index, HashMap<Integer, List<Integer>> graph, boolean[] visited, Queue<Integer> stack) {
        visited[index] = true;

        for(int i : graph.get(index)) {
            if(!visited[i]) {
                helper(i, graph, visited, stack);
            }
        }
        stack.offer(index);
    }

    boolean hasCycle(int index, HashMap<Integer, List<Integer>> graph, boolean[] visited, boolean[] recPath) {
        visited[index] = true;

        recPath[index] = true;
        for(int d : graph.get(index)) {
            if(visited[d]) {
                if(recPath[d]) return true;
            }
            else {
                if(hasCycle(d, graph, visited, recPath)) return true;
            }
        }
        recPath[index] = false;
        return false;
    }
}
