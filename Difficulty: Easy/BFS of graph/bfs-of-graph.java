class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();              // Corrected: use size() not length
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ls = new ArrayList<>();

        q.add(0);
        vis[0] = true;                   // Mark starting node as visited

        while (!q.isEmpty()) {
            int no = q.poll();
            ls.add(no);

            for (int it : adj.get(no)) { // Corrected: access neighbors of `no`
                if (!vis[it]) {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        return ls;
    }
}
