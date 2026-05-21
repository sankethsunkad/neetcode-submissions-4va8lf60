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
            int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for(int[] d : dir) {
                int xcor = x + d[0];
                int ycor = y + d[1];
                if(xcor >= 0 && xcor < n && ycor >=0 && ycor < m && visited[xcor][ycor] != 1 && grid[xcor][ycor] == 1) {
                    rottenQueue.offer(new int[]{xcor, ycor, time + 1});
                    visited[xcor][ycor] = 1;
                }
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
