class Solution {
    public static int longestValidParentheses(String s) {
         int maxLength = 0;
        // Stack to store indices
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        // Push -1 to handle base for first valid substring
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // Push the index of '('
                stack.push(i);
            } else {
                // Pop the previous index
                stack.pop();
                if (stack.isEmpty()) {
                    // If empty, push current index as base for next valid substring
                    stack.push(i);
                } else {
                    // Calculate valid length
                    int length = i - stack.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";

        System.out.println("Input: " + s1 + " → Output: " + longestValidParentheses(s1)); // 2
        System.out.println("Input: " + s2 + " → Output: " + longestValidParentheses(s2)); // 4
        System.out.println("Input: \"" + s3 + "\" → Output: " + longestValidParentheses(s3));
    }
}