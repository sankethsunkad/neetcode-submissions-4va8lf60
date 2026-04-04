class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        int n = points.length;
        for(int i = 0;i < n;i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1;j < n;j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        int res = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0, 0});
        HashSet<Integer> visited = new HashSet<>();

        while(visited.size() < n) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int index = curr[1];

            if(visited.contains(index)) continue;

            res += cost;
            visited.add(index);

            for(int[] nei : adj.getOrDefault(index, new ArrayList<>())){
                if(!visited.contains(nei[1])) {
                    minHeap.offer(new int[]{nei[0], nei[1]});
                }
            }
        }
        return res;
    }
}
