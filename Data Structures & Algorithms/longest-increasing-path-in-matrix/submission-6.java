class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] indegree = new int[n][m];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                for(int[] d : dir) {
                    int row = i + d[0];
                    int col = j + d[1];
                    if(row >=0 && row < n && col >=0 && col < m && matrix[i][j] > matrix[row][col]) {
                        indegree[i][j]++;
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
                for(int[] d : dir) {
                    int row = curr[0] + d[0];
                    int col = curr[1] + d[1];
                    if(row >=0 && row < n && col >=0 && col < m && matrix[row][col] > matrix[curr[0]][curr[1]]) {
                        indegree[row][col]--;
                        if(indegree[row][col] == 0) {
                            q.offer(new int[]{row, col});
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
}
