class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = 1;
                } 
            }
        }
        if(q.size() == 0 || q.size() == n * m) return -1;
        int maxDist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i < size;i++) {
                int[] curr = q.poll();
                for(int[] d : dirs) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    int dist = curr[2];
                    if(x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == 0 && grid[x][y] == 0) {
                        visited[x][y] = 1;
                        maxDist = Math.max(maxDist, dist + 1);
                        q.offer(new int[]{x, y, dist + 1});
                    }
                }
            }
        }
        return maxDist;
    }
}
