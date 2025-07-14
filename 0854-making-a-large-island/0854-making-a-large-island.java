class Dsu {
    int[] size, parent;

    Dsu(int n) {
        size = new int[n];
        parent = new int[n];

        for (int i = 0; i <n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

    }
}

class Solution {
    public int largestIsland(int[][] grid) {

        int n = grid.length;
        Dsu ds = new Dsu(n * n);
            int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr >= 0 && nc >= 0 && n > nc && n > nr && grid[nr][nc] == 1) {
                        int node = n * i + j;
                        int adjn = n * nr + nc;
                        ds.union(node, adjn);
                    }
                }

            }
        }
           int max =0;
        for (int i = 0; i < n; i++) {
           for(int j=0;j<n;j++){
            if (grid[i][j] == 1)
                    continue;
         HashSet<Integer> set = new HashSet<>();
         for(int k=0;k<4;k++){
             int nr = i + dr[k];
             int nc = j + dc[k];
              if (nr >= 0 && nc >= 0 && n > nc && n > nr && grid[nr][nc] == 1) {
                    set.add(ds.find(nr * n + nc));
             }
         
           }
           int size =0;
           for(int x:set){
            size+= ds.size[ds.find(x)];
           }
           max = Math.max(max,size+1);
        }


    }
    for (int i = 0; i < n*n ;i++) {
    if (ds.parent[i] == i) {
        max = Math.max(max, ds.size[i]);
    }
}

return max; 
}
}