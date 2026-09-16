class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}};
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        int[][] visited = new int[m][n];
        int[][] dp = new int[m][n];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        this.m = m;
        this.n = n;
        return helper(0, 0, visited, dp);
    }

    int helper(int i, int j, int[][] visited, int[][] dp) {
        if(i == m - 1 && j == n - 1) return 1;
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        visited[i][j] = 1;

        int res = 0;
        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && visited[nr][nc] == 0) {
                res += helper(nr, nc, visited, dp);
            }
        }
        visited[i][j] = 0;
        dp[i][j] = res;
        return res;
    }
}
