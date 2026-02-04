class Solution {
    public static int pivotInteger(int n) {
        int total = n * (n + 1) / 2;
        int x = (int)Math.sqrt(total);
        if (x * x == total) {
            return x;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pivotInteger(n));
    }
}