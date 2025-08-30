class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1|| n<=numRows) return s;
        char[] arr = new char[n];
        int section = 2*(numRows-1);
        int index =0;
        for(int i =0; i<numRows; i++){
            int step = section-2*i;
            for(int j = i; j<n; j+=section){
                arr[index++] = s.charAt(j);
                if(step<section && step>0 && index<n && j+step<n){
                    arr[index++] = s.charAt(j+step);
                }
            }
        }
        return new String(arr);
    }
}