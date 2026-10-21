

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];

        for (int curr : favorite) {
            indegree[curr]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] depth = new int[n];

        while (!q.isEmpty()) {
            int curr = q.poll();
            int fav = favorite[curr];

            depth[fav] = Math.max(
                depth[fav], depth[curr] + 1
            );

            indegree[fav]--;

            if (indegree[fav] == 0) {
                q.offer(fav);
            }
        }

        int longestCycle = 0;
        int pairSum = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0 || visited[i]) {
                continue;
            }

            int curr = i;
            int length = 0;

            while (!visited[curr]) {
                visited[curr] = true;
                length++;
                curr = favorite[curr];
            }

            longestCycle = Math.max(longestCycle, length);

            if (length == 2) {
                int a = i;
                int b = favorite[i];

                pairSum += 2 + depth[a] + depth[b];
            }
        }

        return Math.max(longestCycle, pairSum);
    }
}
