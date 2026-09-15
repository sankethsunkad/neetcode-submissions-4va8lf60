class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> edgeList = new HashMap<>();
        for(int i = 0;i < n;i++) {
            edgeList.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }

        HashMap<Integer, Integer> mapHeight = new HashMap<>();

        int minH = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            int h = 0;

            while(!q.isEmpty()) {
                int size = q.size();
                for(int j = 0;j < size;j++) {
                    int curr = q.poll();
                    for(int currEdge : edgeList.get(curr)) {
                        if(!visited[currEdge]) {
                            visited[currEdge] = true;
                            q.offer(currEdge);
                        }
                    }
                }
                h++;
            }
            mapHeight.put(i, h);
            minH = Math.min(minH, h);
        }

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mapHeight.entrySet()) {
            if(entry.getValue() == minH) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}