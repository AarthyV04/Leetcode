class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;
        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < n && totalChars + 1 + words[last].length() <= maxWidth) {
                totalChars += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int numberOfWords = last - index;
            if (last == n || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        sb.append(' ');
                    }
                }
                int remaining = maxWidth - sb.length();
                for (int i = 0; i < remaining; i++) {
                    sb.append(' ');
                }
            } else {
                int totalSpaces = maxWidth - totalChars + (numberOfWords - 1); 
                int spacesBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        int spacesToApply = spacesBetweenWords + ( (i - index) < extraSpaces ? 1 : 0 );
                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(' ');
                        }
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}