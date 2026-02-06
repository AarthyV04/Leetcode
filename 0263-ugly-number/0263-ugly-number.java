class Solution {
    public boolean isUgly(int n) {
         if (n <= 0) {
            return false;
        }
        int[] primes = {2, 3, 5};
        for (int p : primes) {
            while (n % p == 0) {
                n /= p;
            }
        }
        return n == 1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUgly(6));   
        System.out.println(sol.isUgly(1));   
        System.out.println(sol.isUgly(14));  
    }
}