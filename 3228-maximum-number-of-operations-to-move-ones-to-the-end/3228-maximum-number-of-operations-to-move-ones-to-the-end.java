class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        long onesCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                onesCount++;
            } else { // c == '0'
                if (i > 0 && s.charAt(i - 1) == '1') {
                    ans += onesCount;
                }
            }
        }
        return ans;
    }
}