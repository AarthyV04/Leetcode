class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        boolean inSegment = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ' && !inSegment) {
                count++;
                inSegment = true;
            } else if (c == ' ') {
                inSegment = false;
            }
        }
        return count;
    }
}