class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for (int zero = 0; zero + zero * zero <= n; zero++) {
            int lastInvalidPos = -1;
            int[] count = new int[2];  
            for (int l = 0, r = 0; r < n; r++) {
                count[s.charAt(r) - '0']++;
                while (l < r) {
                    if (s.charAt(l) == '0' && count[0] > zero) {
                        count[0]--;
                        lastInvalidPos = l;
                        l++;
                    }
                    else if (s.charAt(l) == '1' && count[1] - 1 >= zero * zero) {
                        count[1]--;
                        l++;
                    } else {
                        break;
                    }
                }
                if (count[0] == zero && count[1] >= zero * zero) {
                    ans += (l - lastInvalidPos);
                }
            }
        }
        return ans;
    }
}