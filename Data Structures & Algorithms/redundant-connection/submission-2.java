class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] rank = new int[n];
        int[] parent = new int[n];
        for(int i = 0;i < n;i++) {
            rank[i] = 1;
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            u = find(u, parent);
            v = find(v, parent);
            if(u == v) return edge;
            if(rank[u] >= rank[v]) {
                rank[u] = rank[u] + rank[v];
                parent[v] = u;
            }
            else {
                rank[v] = rank[v] + rank[u];
                parent[u] = v;
            }
        }
        return new int[0];
    }

    int find(int index, int[] parent) {
        while(parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}


