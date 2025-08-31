class Solution {
    public static int missingNumber(int[] nums) {
       int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum; 
    }
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));       
        System.out.println(missingNumber(new int[]{0,1}));          
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); 
    }
}