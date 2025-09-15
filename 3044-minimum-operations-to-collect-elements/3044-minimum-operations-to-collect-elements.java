class Solution {
    public static int minOperations(List<Integer> nums, int k) {
        Set<Integer> collected = new HashSet<>();
        int operations = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            operations++;
            collected.add(nums.get(i));
            boolean allCollected = true;
            for (int x = 1; x <= k; x++) {
                if (!collected.contains(x)) {
                    allCollected = false;
                    break;
                }
            }
            if (allCollected) {
                return operations;
            }
        }
        return operations;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(List.of(3,1,5,4,2), 2));  
        System.out.println(minOperations(List.of(3,1,5,4,2), 5));  
        System.out.println(minOperations(List.of(3,2,5,3,1), 3));
    }
}