class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                
            backtrack(result, current, nums, i + 1); 
            current.remove(current.size() - 1);
        }  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> result = subsets(nums);
        System.out.println("All subsets (power set):");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
        sc.close();
    }
}