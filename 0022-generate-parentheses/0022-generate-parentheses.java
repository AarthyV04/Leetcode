class Solution {
    public void backtrack(List<String> res,StringBuilder s,int open, int closed,int n){
        if(open==closed && open==n){
            res.add(s.toString());
            return;
        }
        if(open<n){
            s.append('(');
            backtrack(res,s,open+1,closed,n);
            s.deleteCharAt(s.length()-1);
        }
        if(closed<open){
            s.append(')');
            backtrack(res,s,open,closed+1,n);
            s.deleteCharAt(s.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder stack=new StringBuilder();
        backtrack(res,stack,0,0,n);
        return res;
    }
}