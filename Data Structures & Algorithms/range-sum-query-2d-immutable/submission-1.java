class NumMatrix {
    int[][] matrix;
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        this.prefix = new int[n][m];

        for(int i = 0;i < n;i++) {
            int[] row = new int[m];
            for(int j = 0;j < m;j++) {
                row[j] += matrix[i][j];
                if(j > 0) {
                    row[j] += row[j - 1];
                }

                if(i > 0) {
                    prefix[i][j] = row[j] + prefix[i - 1][j];
                }
                else {
                    prefix[i][j] = row[j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        sum = prefix[row2][col2];
        if(row1 > 0) {
            sum = sum - prefix[row1 - 1][col2];
        }
        if(col1 > 0) {
            sum = sum - prefix[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            sum += prefix[row1 - 1][col1 - 1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */