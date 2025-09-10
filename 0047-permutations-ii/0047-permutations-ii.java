class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates easily
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }
     private static void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip if already used
            if (used[i]) continue;
            
            // Skip duplicates: if same as previous and previous was not used in this recursion
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            
            current.add(nums[i]);
            used[i] = true;
            
            backtrack(nums, current, used, result);
            
            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Unique permutations: " + permuteUnique(nums1));

        int[] nums2 = {1, 2, 3};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Unique permutations: " + permuteUnique(nums2));
    }
}