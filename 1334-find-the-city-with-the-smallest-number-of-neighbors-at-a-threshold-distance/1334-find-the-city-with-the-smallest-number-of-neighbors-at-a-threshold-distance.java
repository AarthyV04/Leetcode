class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       int INF = distanceThreshold + 1;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);
        for (int i = 0; i < n; i++)
            dist[i][i] = 0;

        // Fill direct edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Floyd-Warshall: compute shortest paths
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        // Find the city with minimum reachable count (tie → highest index)
        int result = 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= minCount) {
                minCount = count;
                result = i;
            }
        }

        return result; 
    }
}