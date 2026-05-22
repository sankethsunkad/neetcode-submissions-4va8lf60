class Solution {
    int n;
    int m;
    int[][] heights;
    boolean[][] pacific;
    boolean[][] atlantic;

    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.n = heights.length;
        this.m = heights[0].length;

        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i < n;i++) {
            helper(i, 0, pacific);
        }
        for(int j = 0;j < m;j++) {
            helper(0, j, pacific);
        }

        for(int i = 0;i < n;i++) {
            helper(i, m - 1, atlantic);
        }
        for(int j = 0;j < m;j++) {
            helper(n - 1, j, atlantic);
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void helper(int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        for(int[] d : dir) {
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr < 0 || nc < 0 || nr == n || nc == m || heights[nr][nc] < heights[i][j] || visited[nr][nc]) {
                continue;
            }
            helper(nr, nc, visited);
        }
    }


}
