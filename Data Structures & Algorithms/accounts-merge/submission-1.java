class Solution {
    int[] parent;
    int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        Map<String, Integer> emailOwner = new HashMap<>();

        // Connect accounts sharing at least one email
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailOwner.containsKey(email)) {
                    emailOwner.put(email, i);
                } else {
                    union(i, emailOwner.get(email));
                }
            }
        }

        // Group emails according to the root account
        Map<Integer, TreeSet<String>> groupedEmails = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailOwner.entrySet()) {
            String email = entry.getKey();
            int root = find(entry.getValue());

            groupedEmails
                .computeIfAbsent(root, key -> new TreeSet<>())
                .add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, TreeSet<String>> entry
                : groupedEmails.entrySet()) {

            int root = entry.getKey();

            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(root).get(0));
            mergedAccount.addAll(entry.getValue());

            result.add(mergedAccount);
        }

        return result;
    }

    int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }

        return parent[node];
    }

    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }

        // Union by rank
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
}