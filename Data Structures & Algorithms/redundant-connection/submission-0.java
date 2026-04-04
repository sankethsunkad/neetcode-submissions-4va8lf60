class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }
}

class DSU {
    int[] parent;
    int[] rank;
    DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 0;i < n + 1;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int node) {
        int cur = node;
        while(parent[cur] != cur) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }

    boolean union(int u, int v) {
        int p1 = find(u);
        int p2 = find(v);
        if(p1 == p2) return false;
        if(rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        return true;
    }
}
