class Solution {
    public double myPow(double x, int n) {
        long N = n; 
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current = x;
        while (N > 0) {
            if ((N & 1) == 1) {
                ans = ans * current;
            }
            current = current * current;
            N >>= 1;
        }
        return ans;
    }
}