class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int []> rottenQueue = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] validate = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(validate[i], Integer.MAX_VALUE);
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j, 0});
                }
            }
        }

        int res = 0;
        int[][] visited = new int[n][m];
        while(!rottenQueue.isEmpty()) 
        {
            Queue<int []> queue = new LinkedList<>();
            queue.offer(rottenQueue.poll());

            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], 0);
            }
            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                visited[x][y] = 1;
                int time = curr[2];
                validate[x][y] = Math.min(validate[x][y], time);
                if((x + 1) < n && (x + 1) >= 0 && visited[x + 1][y] != 1 && grid[x + 1][y] == 1) {
                    queue.offer(new int[]{x + 1, y, time + 1});
                }

                if((x - 1) < n && (x - 1) >= 0 && visited[x - 1][y] != 1 && grid[x - 1][y] == 1) {
                    queue.offer(new int[]{x - 1, y, time + 1});
                }

                if((y - 1) < m && (y - 1) >= 0 && visited[x][y - 1] != 1 && grid[x][y - 1] == 1) {
                    queue.offer(new int[]{x, y - 1, time + 1});
                }

                if((y + 1) < m && (y + 1) >= 0 && visited[x][y + 1] != 1 && grid[x][y + 1] == 1) {
                    queue.offer(new int[]{x, y + 1, time + 1});
                }
            }
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(validate[i][j] == Integer.MAX_VALUE && grid[i][j] == 1) return -1;
                if(validate[i][j] != Integer.MAX_VALUE) {
                    res = Math.max(res, validate[i][j]);
                }
            }
        }

        return res;
    }
}
