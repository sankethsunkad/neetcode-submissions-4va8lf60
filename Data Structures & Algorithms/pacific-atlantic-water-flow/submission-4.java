class Solution {
    int n;
    int m;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        this.heights = heights;
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlanticVisited = new boolean[n][m];
        boolean[][] pacificVisited = new boolean[n][m];
        List<List<Integer>> res = new ArrayList<>();

        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for(int i = 0;i < m;i++) {
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        for(int i = 0;i < n;i++) {
           pacific[i][0] = true;
           atlantic[i][m - 1] = true;
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(pacific[i][j]) {
                    pacificQ.offer(new int[]{i, j});
                }
                if(atlantic[i][j]) {
                    atlanticQ.offer(new int[]{i, j});
                
                }
            }
        }
        helper(pacificQ, pacificVisited, pacific);
        helper(atlanticQ, atlanticVisited, atlantic);


        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    res.add(curr);
                }
            }
        }

        return res;
    }


    void helper(Queue<int[]> q, boolean[][] visited, boolean[][] matrix) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if(visited[x][y]) {
                continue;
            }
            visited[curr[0]][curr[1]] = true;

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                    matrix[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
