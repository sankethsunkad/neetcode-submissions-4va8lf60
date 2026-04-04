class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int []> rottenQueue = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j, 0});
                    visited[i][j] = 1;
                }
            }
        }

        int res = 0;
        while(!rottenQueue.isEmpty()) 
        {   
                int[] curr = rottenQueue.poll();
                int x = curr[0];
                int y = curr[1];
                
                int time = curr[2];
                res = Math.max(res, time);
                if((x + 1) < n && (x + 1) >= 0 && visited[x + 1][y] != 1 && grid[x + 1][y] == 1) {
                    rottenQueue.offer(new int[]{x + 1, y, time + 1});
                    visited[x + 1][y] = 1;
                }

                if((x - 1) < n && (x - 1) >= 0 && visited[x - 1][y] != 1 && grid[x - 1][y] == 1) {
                    rottenQueue.offer(new int[]{x - 1, y, time + 1});
                    visited[x - 1][y] = 1;
                }

                if((y - 1) < m && (y - 1) >= 0 && visited[x][y - 1] != 1 && grid[x][y - 1] == 1) {
                    rottenQueue.offer(new int[]{x, y - 1, time + 1});
                    visited[x][y - 1] = 1;
                }

                if((y + 1) < m && (y + 1) >= 0 && visited[x][y + 1] != 1 && grid[x][y + 1] == 1) {
                    rottenQueue.offer(new int[]{x, y + 1, time + 1});
                    visited[x][y + 1] = 1;
                }
            
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(visited[i][j] != 1 && grid[i][j] == 1) return -1;
            }
        }

        return res;
    }
}
