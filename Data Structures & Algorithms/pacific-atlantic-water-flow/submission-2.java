class Solution {
    int n, m;
    boolean[][] pacific;
    boolean[][] atlantic;
    int[][] heights;
    int[][] dirs = {{0,1}, {0, -1}, {1, 0,}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.n = heights.length;
        this.m = heights[0].length;
        this.heights = heights;

        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];

        for(int i = 0;i < n;i++) dfs(i, 0, pacific);
        for(int i = 0;i < m;i++) dfs(0, i, pacific);

        for(int i = 0;i < n;i++) dfs(i, m - 1, atlantic);
        for(int i = 0;i < m;i++) dfs(n - 1, i, atlantic);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;
        for(int[] d: dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if(ocean[nr][nc]) continue;
            if(heights[nr][nc] < heights[r][c]) continue;
            dfs(nr, nc, ocean);
        }
    }
    
}
