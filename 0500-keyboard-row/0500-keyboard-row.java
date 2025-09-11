class Solution {
    public String[] findWords(String[] words) {
       String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";
        Set<Character> r1 = new HashSet<>(), r2 = new HashSet<>(), r3 = new HashSet<>();
        for (char c : row1.toCharArray()) r1.add(c);
        for (char c : row2.toCharArray()) r2.add(c);
        for (char c : row3.toCharArray()) r3.add(c);

        List<String> result = new ArrayList<>();
        for (String word : words) {
            String w = word.toLowerCase();
            Set<Character> set = r1.contains(w.charAt(0)) ? r1 :
                                 r2.contains(w.charAt(0)) ? r2 : r3;
            boolean ok = true;
            for (char c : w.toCharArray()) {
                if (!set.contains(c)) {
                    ok = false;
                    break;
                }
            }
            if (ok) result.add(word);
        }
        return result.toArray(new String[0]); 
    }
}