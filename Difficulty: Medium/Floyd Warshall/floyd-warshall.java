class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = 100000000; // 10^8 used to represent infinity

        // Run the Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {           // intermediate node
            for (int i = 0; i < n; i++) {       // source node
                for (int j = 0; j < n; j++) {   // destination node
                    
                    // Only update if both distances are not infinity
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}
