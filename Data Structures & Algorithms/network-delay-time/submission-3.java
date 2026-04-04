public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0],
            key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0, k});
        HashSet<Integer> visited = new HashSet<>();

        int t = 0;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0], v = curr[1];
            if(visited.contains(v)) continue;

            visited.add(v);
            t = w1;

            if(edges.containsKey(v)) {
                for(int[] next : edges.get(v)) {
                    int v2 = next[0];
                    int w2 = next[1];
                    if (!visited.contains(v2)) {
                        minHeap.offer(new int[]{w1 + w2, v2});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}