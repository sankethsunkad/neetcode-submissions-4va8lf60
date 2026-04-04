class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // boolean[][] visited = new boolean[n][m];
        // for(int i = 0;i < n;i++) {
        //     for(int j = 0;j < m;j++) {
        //         if(grid[i][j] == 0) {
        //             markNearestLand(grid, i, j, 0, visited);
        //             for(boolean[] row : visited) {
        //                 Arrays.fill(row, false);
        //             }
        //         }
        //     }
        // }
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if((r + 1) < n && grid[r + 1][c] == Integer.MAX_VALUE) {
                grid[r + 1][c] = grid[r][c] + 1;
                queue.offer(new int[]{r + 1, c});
            }
            if((r - 1) >= 0 && grid[r - 1][c] == Integer.MAX_VALUE) {
                grid[r - 1][c] = grid[r][c] + 1;
                queue.offer(new int[]{r - 1, c});
            }
            if((c + 1) < m && grid[r][c + 1] == Integer.MAX_VALUE) {
                grid[r][c + 1] = grid[r][c] + 1;
                queue.offer(new int[]{r, c + 1});
            }
            if((c - 1) >= 0 && grid[r][c - 1] == Integer.MAX_VALUE) {
                grid[r][c - 1] = grid[r][c] + 1;
                queue.offer(new int[]{r, c - 1});
            }
        }
    }

    public void markNearestLand(int[][] grid, int n, int m, int counter, boolean[][] visited) {
        visited[n][m] = true;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if((n + 1) < rowLength && visited[n + 1][m] != true && grid[n + 1][m] != -1 && grid[n + 1][m] != 0 && grid[n + 1][m] > (counter + 1)) {
            grid[n + 1][m] = Math.min(grid[n + 1][m], counter + 1);
            markNearestLand(grid, n + 1, m, counter + 1, visited);
        }

        if((n - 1) >= 0 && visited[n - 1][m] != true && grid[n - 1][m] != -1 && grid[n - 1][m] != 0 && grid[n - 1][m] > (counter + 1)) {
            grid[n - 1][m] = counter + 1;
            markNearestLand(grid, n - 1, m, counter + 1, visited);
        }

        if((m + 1) < colLength && visited[n][m + 1] != true && grid[n][m + 1] != -1 && grid[n][m + 1] != 0 && grid[n][m + 1] > (counter + 1)) {
            grid[n][m + 1] = counter + 1;
            markNearestLand(grid, n, m + 1, counter + 1, visited);
        }

        if((m - 1) >= 0 && visited[n][m - 1] != true && grid[n][m - 1] != -1 && grid[n][m - 1] != 0 && grid[n][m - 1] > (counter + 1)) {
            grid[n][m - 1] = counter + 1;
            markNearestLand(grid, n, m - 1, counter + 1, visited);
        }
        return;
    }

    public int checkNearestTreasureIndex(int[][] grid, int n, int m, int counter, boolean[][] visited) {
        if(grid[n][m] == 0) return counter;
        visited[n][m] = true;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        int res = Integer.MAX_VALUE;
        if((n + 1) < rowLength && visited[n + 1][m] != true && grid[n + 1][m] != -1) {
            int value = checkNearestTreasureIndex(grid, n + 1, m, counter + 1, visited);
            if(value != Integer.MAX_VALUE) {
                res = Math.min(res, value);
            }
        }
        if((n - 1) >= 0 && visited[n - 1][m] != true && grid[n - 1][m] != -1) {
            int value = checkNearestTreasureIndex(grid, n - 1, m, counter + 1, visited);
            if(value != Integer.MAX_VALUE) {
                res = Math.min(res, value);
            }
        }

        if((m + 1) < colLength && visited[n][m + 1] != true && grid[n][m + 1] != -1) {
            int value = checkNearestTreasureIndex(grid, n, m + 1, counter + 1, visited);
            if(value != Integer.MAX_VALUE) {
                res = Math.min(res, value);
            }
        }

        if((m - 1) >= 0 && visited[n][m - 1] != true && grid[n][m - 1] != -1) {
            int value = checkNearestTreasureIndex(grid, n, m - 1, counter + 1, visited);
            if(value != Integer.MAX_VALUE) {
                res = Math.min(res, value);
            }
        }
        visited[n][m] = false;
        return res;
    }
}
