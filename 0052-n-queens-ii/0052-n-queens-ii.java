class Solution {
    int count = 0;
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        backtrack(0);
        return count;
    }
    private void backtrack(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = row - c + n;
            if (cols[c] || diag1[d1] || diag2[d2]) continue;
            cols[c] = diag1[d1] = diag2[d2] = true;
            backtrack(row + 1);
            cols[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}