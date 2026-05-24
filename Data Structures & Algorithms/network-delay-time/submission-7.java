class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> hm = new HashMap<>();
        for(int i = 0;i <= n;i++) {
            hm.put(i, new ArrayList<>());
        }

        for(int[] time : times) {
            hm.get(time[0]).add(time);
        }

        int[] res = new int[n + 1];
        for(int i = 1;i <= n;i++) {
            if(i == k){
                res[i] = 0;
            }
            else {
                res[i] = Integer.MAX_VALUE;
            }
        }

        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int[] time : hm.get(k)) {
            q.offer(time);
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int v = curr[1];
            int time = curr[2];
            if(res[u] != Integer.MAX_VALUE && res[u] + time < res[v]) {
                res[v] = res[u] + time;
                for(int[] timeArr : hm.get(v)) {
                    q.offer(timeArr);
                }
            }
        }

        int value = 0;
        for(int i = 1;i <= n;i++) {
            if(res[i] == Integer.MAX_VALUE) {
                return -1;
            }
            value = Math.max(value, res[i]);
        }
        return value;
    }
}
