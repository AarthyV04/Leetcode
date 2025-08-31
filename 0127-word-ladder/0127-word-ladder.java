class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) return level;
                char[] arr = current.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char originalChar = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        arr[j] = c;
                        String nextWord = new String(arr);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord); 
                        }
                    }
                    arr[j] = originalChar; 
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(sol.ladderLength("hit", "cog", wordList1));  
        List<String> wordList2 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(sol.ladderLength("hit", "cog", wordList2));
    }
}