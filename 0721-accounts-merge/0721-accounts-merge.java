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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Dis ds = new Dis(n);
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String s = accounts.get(i).get(j);
                if (!hm.containsKey(s)) {
                    hm.put(s, i);
                } else {
                    ds.union(i, hm.get(s));
                }
            }
        }
        List<List<String>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> mp : hm.entrySet()) {
            String s = mp.getKey();
            int node = ds.find(mp.getValue());
            ls.get(node).add(s);
        }

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (ls.get(i).isEmpty())
                continue;
            Collections.sort(ls.get(i));
            List<String> t = new ArrayList<>();
            t.add(accounts.get(i).get(0));
            t.addAll(ls.get(i));
            res.add(t);

        }
        return res;
    }
}