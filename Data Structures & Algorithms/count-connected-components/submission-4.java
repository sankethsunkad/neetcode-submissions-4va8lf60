class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        int res = n;
        for(int i = 0;i < n;i++) {
            parent[i] = i;
            rank[i] = 1;
        } 
        for(int[] d: edges) {
            if(union(d[0], d[1], parent, rank)) {
                res--;
            }
        }
        return res;
    }

    public boolean union(int n1, int n2, int[] parent, int[] rank) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1 == p2) return false;
        if(rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] = rank[p2] + rank[p1];
        }
        else {
            parent[p2] = p1;
            rank[p1] = rank[p1] + rank[p2];
        }
        return true;
    }

    public int find(int n, int[] parent) {
        while(parent[n] != n) {
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }
}
