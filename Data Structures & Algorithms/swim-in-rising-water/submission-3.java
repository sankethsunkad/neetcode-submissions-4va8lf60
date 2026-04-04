class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[N][M];

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == N - 1 && c == M - 1) return t;

            if(r + 1 < N && !visited[r + 1][c]) {
                minHeap.offer(new int[]{Math.max(t, grid[r + 1][c]), r + 1, c});
                visited[r + 1][c] = true;
            }
            if(c + 1 < M && !visited[r][c + 1]) {
                minHeap.offer(new int[]{Math.max(t, grid[r][c + 1]), r, c + 1});
                visited[r][c + 1] = true;
            }
            if(c - 1 >= 0 && !visited[r][c- 1]) {
                minHeap.offer(new int[]{Math.max(t, grid[r][c - 1]), r, c - 1});
                visited[r][c - 1] = true;
            }
            if(r - 1 >= 0 && !visited[r-1][c]) {
                minHeap.offer(new int[]{Math.max(t, grid[r - 1][c]), r - 1, c});
                visited[r - 1][c] = true;
            }
        }
        return -1;
    }
}
