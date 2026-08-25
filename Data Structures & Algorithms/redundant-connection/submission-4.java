class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0;i < n;i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            int pu = find(edge[0] - 1, parent);
            int pv = find(edge[1] - 1, parent);

            if(pu == pv) return edge;

            union(pu, pv, rank, parent);
        }

        return new int[]{};
    }

    int find(int u, int[] parent) {
        while(u != parent[u]) {
            u = parent[u];
        }
        return u;
    }

    void union(int u, int v, int[] rank, int[] parent) {
        if(rank[u] >= rank[v]) {
            rank[u] += rank[v];
            parent[v] = u;
        }
        else {
            rank[v] += rank[u];
            parent[u] = v;
        }
    }
}
