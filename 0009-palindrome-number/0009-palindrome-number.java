class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int dig=0,rev=0;
        while(x>0){
            dig = x%10;
            rev = rev*10+dig;
            x =x/10;
        }
        return rev==temp;
    }
}