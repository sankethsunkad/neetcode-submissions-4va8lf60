class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] indegree = new int[n][m];

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                int r = i;
                int c = j;
                for(int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && matrix[nr][nc] < matrix[r][c]) {
                        indegree[r][c]++;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(indegree[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i < size;i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && matrix[nr][nc] > matrix[r][c]) {
                        indegree[nr][nc]--;
                        if(indegree[nr][nc] == 0) {
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
}
