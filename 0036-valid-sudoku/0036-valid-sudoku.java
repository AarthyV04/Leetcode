class Solution {
    public boolean isValidSudoku(char[][] board) {
       boolean[][] check = new boolean[27][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int row = i, col = j + 9, block = (i/3)*3 + j/3 + 18;
                if(check[row][num] || check[col][num] || check[block][num]) return false;
                check[row][num] = check[col][num] = check[block][num] = true;
            }
        }
        return true;
    }
}