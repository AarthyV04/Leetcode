class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxLength = 0;
        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                int length = freqMap.get(key) + freqMap.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 1};
        System.out.println(sol.findLHS(nums1));
        System.out.println(sol.findLHS(nums2)); 
        System.out.println(sol.findLHS(nums3));
    }
}