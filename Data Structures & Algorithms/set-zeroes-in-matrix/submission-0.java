class Solution {
    public void setZeroes(int[][] matrix) {
        boolean check = false;
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if(i > 0) {
                        matrix[i][0] = 0;
                    }
                    else {
                        check = true;
                    }
                }
            }
        }

        for(int i = 1;i < n;i++) {
            for(int j = 1;j < m;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int r = 0; r < n; r++) {
                matrix[r][0] = 0;
            }
        }

        if (check) {
            for (int c = 0; c < m; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}
