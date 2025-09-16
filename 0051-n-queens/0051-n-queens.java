class Solution {
    List<List<String>> res = new ArrayList<>(); 
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    char[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0);
        return res;
    }
    private void backtrack(int row) {
        if (row == n) {
            List<String> one = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                one.add(new String(board[i]));
            }
            res.add(one);
            return;
        }
        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = row - c + n; 
            if (cols[c] || diag1[d1] || diag2[d2]) continue;
            board[row][c] = 'Q';
            cols[c] = diag1[d1] = diag2[d2] = true;
            backtrack(row + 1);
            board[row][c] = '.';
            cols[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}