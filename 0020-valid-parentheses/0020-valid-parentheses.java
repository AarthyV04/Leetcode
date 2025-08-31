class Solution {
    public boolean isValid(String s) {

        char[] cs = s.toCharArray();
        int n = cs.length;
        char[] stack = new char[n];
        int top = -1;

        for(int i = 0; i < n; ++i){
            char c = cs[i];
            if(c == '(' || c == '{' || c == '[' ){
                stack[++top] = c;
                continue;
            }
            
            if(c == ')' && top != -1 && stack[top] == '(')
                top--;
            else if(c == '}' && top != -1 && stack[top] == '{')
                top--;
            else if(c == ']' && top != -1 && stack[top] == '[')
                top--;
            else
                return false;
        }
        
        return top == -1;
    }
}
