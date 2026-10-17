class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] unguarded = new int[m][n];
        for(int[] wall : walls) {
            unguarded[wall[0]][wall[1]] = -1;
        }


        for(int[] guard : guards) {
            helper(guard[0], guard[1], m, n, unguarded);
        }

        int res = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(unguarded[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    void helper(int i, int j, int m, int n, int[][] unguarded) {
        unguarded[i][j] = 1;

        for(int col = j + 1;col < n;col++) {
            if(unguarded[i][col] == -1 || unguarded[i][col] == 1) break;
            unguarded[i][col] = 2;
        }

        for(int col = j - 1;col >= 0;col--) {
            if(unguarded[i][col] == -1 || unguarded[i][col] == 1) break;
            unguarded[i][col] = 2;
        }

        for(int row = i + 1;row < m;row++) {
            if(unguarded[row][j] == -1 || unguarded[row][j] == 1) break;
            unguarded[row][j] = 2;
        }

        for(int row = i - 1;row >= 0;row--) {
            if(unguarded[row][j] == -1 || unguarded[row][j] == 1) break;
            unguarded[row][j] = 2;
        }
    }
}
