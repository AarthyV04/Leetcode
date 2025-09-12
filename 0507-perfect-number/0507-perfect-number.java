class Solution {
    public boolean checkPerfectNumber(int num) {
       if (num <= 1) {
        return false; 
       } 
        int sum = 1; 
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                int other = num / i;
                sum += i;
                if (other != i){
                    sum += other; 
                } 
            }
        }
        return sum == num;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tests = {1, 2, 3, 6, 28, 496, 8128};
        for (int t : tests) {
            System.out.printf("%d -> %b\n", t, s.checkPerfectNumber(t));
        }
    }
}