class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        int result = 0;
         while (dividendL >= divisorL) {
            long temp = divisorL, multiple = 1;
            while (dividendL >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividendL -= temp;
            result += multiple;
        }
        return negative ? -result : result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));   
        System.out.println(solution.divide(7, -3));   
        System.out.println(solution.divide(-15, 2));  
    }
}