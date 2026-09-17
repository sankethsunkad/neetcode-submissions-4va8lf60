class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, List<double[]>> edgeList = new HashMap<>();

        int i = 0;
        for(int j = 0;j < n;j++) {
            edgeList.put(j, new ArrayList<>());
        }
        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];            
            edgeList.get(u).add(new double[]{v, succProb[i]});
            edgeList.get(v).add(new double[]{u, succProb[i]});
            i++;
        }

        int res = 0;
        double[] prob = new double[n];
        
        PriorityQueue<double[]> maxQ = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        maxQ.offer(new double[]{start_node, 1.0});

        while(!maxQ.isEmpty()) {
            double curr[] = maxQ.poll();
            int u = (int)curr[0];
            double uProb = curr[1];

            if(u == end_node) {
                return uProb;
            }
            if(uProb < prob[u]) {
                continue;
            }
            
            for(double[] currEgde : edgeList.get(u)) {
                int v = (int)currEgde[0];
                double newProb = uProb * currEgde[1];
                if(newProb > prob[v]) {
                    prob[v] = newProb;
                    maxQ.offer(new double[]{v, newProb});
                }
            }
             
        }
        return 0.0;
    }
}