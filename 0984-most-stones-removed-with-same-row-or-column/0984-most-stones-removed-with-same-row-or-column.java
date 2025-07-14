class Solution {

    class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findUPar(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findUPar(parent[node]); // path compression
        }

        void unionBySize(int u, int v) {
            int pu = findUPar(u);
            int pv = findUPar(v);
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;

        // Step 1: Get max row and col index
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Step 2: DSU size = maxRow + maxCol + 2
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        // Step 3: Connect each stone's row and shifted column
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            ds.unionBySize(row, col);
        }

        // Step 4: Count number of valid components
        int components = 0;
        for (int i = 0; i < maxRow + maxCol + 2; i++) {
            if (ds.parent[i] == i && ds.size[i] > 1) {
                components++;
            }
        }

        // Step 5: Max stones we can remove = total stones - components
        return stones.length - components;
    }
}
