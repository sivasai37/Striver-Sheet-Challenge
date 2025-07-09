class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // because it's an undirected graph
        }

        // Step 2: Prepare visited array and result list
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        // Step 3: Find connected components using DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, visited, adj, comp);
                components.add(comp);
            }
        }

        return components;
    }

    // DFS Helper to collect all nodes in one component
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> comp) {
        visited[node] = true;
        comp.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, comp);
            }
        }
    }
}
