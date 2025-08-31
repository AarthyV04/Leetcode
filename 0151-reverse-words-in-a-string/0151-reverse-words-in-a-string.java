class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // split on whitespace
        StringBuilder reversed = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            reversed.append(words[i]);
            if(i != 0) reversed.append(" ");
        }
        return reversed.toString();
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String param_1 = "hello world this is chatgpt";
        String ret = sol.reverseWords(param_1);
        System.out.println(ret);
    }
}