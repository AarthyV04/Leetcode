import java.util.Arrays;
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 
        reverse(nums, 0, n - 1);        
        reverse(nums, 0, k - 1);       
        reverse(nums, k, n - 1); 
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
     public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,2,3,4,5,6,7};
        sol.rotate(arr1, 3);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {-1,-100,3,99};
        sol.rotate(arr2, 2);
        System.out.println(Arrays.toString(arr2));  
    }
}