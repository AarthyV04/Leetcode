class Solution {
    public static int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + lengthOfLastWord(s1));

        String s2 = "   fly me   to   the moon  ";
        System.out.println("\nInput: \"" + s2 + "\"");
        System.out.println("Output: " + lengthOfLastWord(s2));

        String s3 = "luffy is still joyboy";
        System.out.println("\nInput: \"" + s3 + "\"");
        System.out.println("Output: " + lengthOfLastWord(s3));
    
    }
}