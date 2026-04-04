class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] d : times) {
            map.get(d[0] - 1).add(new int[]{d[1] - 1,d[2]});
        }
        int[] res = new int[n];
        for(int i = 0;i < n;i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[k - 1] = 0;
        dfs(k - 1, map, 0, res);
        int ret = 0;
        for(int i = 0;i < n;i++) {
            ret = Math.max(ret, res[i]);
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    void dfs(int source, Map<Integer, List<int[]>> map, int time, int[] res) {
        List<int[]> adjList = map.get(source);
        for(int[] d : adjList) {
            if(time + d[1] < res[d[0]]) {
                res[d[0]] = time + d[1];
                dfs(d[0], map, time + d[1], res);
            }
        }
    }
}
