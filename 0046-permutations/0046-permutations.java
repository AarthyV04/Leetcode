class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Make a deep copy
            return;
        }
        for (int num : nums) {
            if (current.contains(num)) continue; 
            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1); 
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> output = sol.permute(nums);
        System.out.println(output);
    }
}