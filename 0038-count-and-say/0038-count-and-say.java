class Solution {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        char currentChar = prev.charAt(0);
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count).append(currentChar);
                currentChar = prev.charAt(i);
                count = 1;
            }
        }
        result.append(count).append(currentChar);
        return result.toString();
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }
}