class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    helper(i, j, grid, 0);
                }
            }
        }   
    }

    void helper(int i, int j, int[][] grid, int distance) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }

        if(distance <= grid[i][j]) {
            grid[i][j] = distance;
            helper(i, j, grid, distance + 1);
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for(int[] d : dir) {
                helper(i + d[0], j + d[1], grid, distance + 1);
            }
        }
    }
}
