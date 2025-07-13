// User function Template for Java
class Dis {
    int[] parent, rank;

    Dis(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
            rank[pu] += rank[pv];
        } else if (rank[pv] > rank[pu]) {
            parent[pu] = pv;
            rank[pv] += rank[pu];
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}

class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        Dis ds = new Dis(rows * cols);
        int[][] vis = new int[rows][cols];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int n = operators.length;
        int count =0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int r = operators[i][0];
            int c = operators[i][1];
            
            if(vis[r][c]==1){
                ans.add(count);
                continue;
            }
            
            vis[r][c] =1;
            count++;
             int node = r * cols + c;

            
            for(int k =0;k<4;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr>=0 && nc>=0 && nr<rows  && cols>nc){
                    if(vis[nr][nc]==1){
                       int adjn = nr * cols + nc;
                        if(ds.find(node)!= ds.find(adjn)){
                            count--;
                            ds.union(node,adjn);
                        }
                    }
                }
                
            }
            ans.add(count);
        }
        return ans;
    }
}