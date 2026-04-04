class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null) {
            return true;
        }
        return checkRowValidation(board, 0) && checkColumnValidation(board, 0) && checkCellValidation(board, 0, 0);
    }
    public boolean checkRowValidation(char[][] board, int row) {
        if(row >= board.length) {
            return true;
        }
        boolean[] rowCheck = new boolean[9];
        for(int i = 0;i < 9;i++) {
            if(board[row][i] != '.') {
                
            
            int num = board[row][i] - '1';
            if(rowCheck[num] == true) {
                return false;
            }
            rowCheck[num] = true;
            }
        }
        return checkRowValidation(board, row + 1);
    }
    public boolean checkColumnValidation(char[][] board, int column) {
        if(column >= board[0].length) {
            return true;
        }
        boolean[] colCheck = new boolean[9];
        for(int i = 0;i < 9;i++) {
            if(board[i][column] != '.') {
                
            
            int num = board[i][column] - '1';
            if(colCheck[num] == true) {
                return false;
            }
            colCheck[num] = true;
            }
        }
        return checkColumnValidation(board, column + 1);
    }
    public boolean checkCellValidation(char[][] board, int row, int column) {
        if(column >= board[0].length || row >= board.length) {
            return true;
        }
        boolean[] Check = new boolean[9];
        for(int r = row; r < row + 3; r++) {
                for(int c = column; c < column + 3;c++) {
                    if(board[r][c] != '.') {
                    
                
                int num = board[r][c] - '1';
                if(Check[num] == true) {
                    return false;
                }
                Check[num] = true;
                    }
            }
        }
        return checkCellValidation(board, row + 3, column) && checkCellValidation(board, row, column + 3);
    }
}
