class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // PriorityQueue to store {weight, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        boolean[] vis = new boolean[V];
        pq.add(new int[]{0, 0}); // {weight, node}
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];

            if (vis[node]) continue;

            vis[node] = true;
            sum += wt;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int adjWt = neighbor[1];

               
                    pq.add(new int[]{adjWt, adjNode});
                
            }
        }

        return sum;
    }
}
