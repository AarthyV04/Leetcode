class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        
        int j = n - 1;        
        int k = m + n - 1;    
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m (number of elements in nums1): ");
        int m = sc.nextInt();
        System.out.print("Enter n (number of elements in nums2): ");
        int n = sc.nextInt();
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];
        System.out.print("Enter " + m + " elements of nums1: ");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        System.out.print("Enter " + n + " elements of nums2: ");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        merge(nums1, m, nums2, n);
        System.out.println("Merged array: " + Arrays.toString(nums1));
        sc.close();
    }
}