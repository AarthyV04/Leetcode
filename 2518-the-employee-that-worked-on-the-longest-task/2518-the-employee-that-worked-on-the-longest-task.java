class Solution {
    public int hardestWorker(int n, int[][] logs) {
         int maxTime = logs[0][1];
        int resultId = logs[0][0];

        for (int i = 1; i < logs.length; i++) {
            int duration = logs[i][1] - logs[i - 1][1];
            int currentId = logs[i][0];

            if (duration > maxTime || (duration == maxTime && currentId < resultId)) {
                maxTime = duration;
                resultId = currentId;
            }
        }

        return resultId;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] logs1 = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        System.out.println(solution.hardestWorker(10, logs1)); // Output: 1

        // Example 2
        int[][] logs2 = {{1, 1}, {3, 7}, {2, 12}, {7, 17}};
        System.out.println(solution.hardestWorker(26, logs2)); // Output: 3

        // Example 3
        int[][] logs3 = {{0, 10}, {1, 20}};
        System.out.println(solution.hardestWorker(2, logs3));
    }
}