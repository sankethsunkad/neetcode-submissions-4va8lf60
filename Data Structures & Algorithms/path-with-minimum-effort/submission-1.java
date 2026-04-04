class Solution {
    int n;
    int m;
    public int minimumEffortPath(int[][] heights) {
        this.n = heights.length;
        this.m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[]{0, 0, 0});
        int[][] dir = new int[][] {{1, 0},{0, 1},{-1, 0},{0, -1}};
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[0];
            int j = curr[1];
            visited[i][j] = true;
            if(i == n - 1 && j == m - 1) {
                return curr[2];
            }
            for(int[] d : dir) {
                if(i + d[0] < n && i + d[0] >=0 && !visited[i + d[0]][j]) {
                    minHeap.offer(new int[]{i + d[0], j, Math.max(curr[2], Math.abs(heights[i + d[0]][j] - heights[i][j]))});
                }
                if(j + d[1] < m && j + d[1] >=0 && !visited[i][j + d[1]]) {
                    minHeap.offer(new int[]{i, j + d[1], Math.max(curr[2], Math.abs(heights[i][j + d[1]] - heights[i][j]))});
                }
            }
        }
        return -1;
    }

    int helper(int[][] heights, boolean[][] visited, int i, int j) {
        if(i == n - 1 && j == m - 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        if((i + 1) < n && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            res = Math.min(res, Math.max(Math.abs(heights[i][j] - heights[i + 1][j]), helper(heights, visited, i + 1, j)));
            visited[i + 1][j] = false;
        }
        if((j + 1) < m && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            res = Math.min(res, Math.max(Math.abs(heights[i][j] - heights[i][j + 1]), helper(heights, visited, i, j + 1)));
            visited[i][j + 1] = false;
        }
        if((i - 1) >= 0 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            res = Math.min(res, Math.max(Math.abs(heights[i][j] - heights[i - 1][j]), helper(heights, visited, i - 1, j)));
            visited[i - 1][j] = false;
        }
        if((j - 1) >= 0 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            res = Math.min(res, Math.max(Math.abs(heights[i][j] - heights[i][j - 1]), helper(heights, visited, i, j - 1)));
            visited[i][j - 1] = false;
        }
        
        return res;
    }
}