class Solution {
    LinkedList<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> curr : tickets) {
            graph.putIfAbsent(curr.get(0), new PriorityQueue<>());
            graph.get(curr.get(0)).offer(curr.get(1));
        }

        helper(graph, "JFK");
        return res;
    }

    void helper(HashMap<String, PriorityQueue<String>> graph, String origin) {
        PriorityQueue<String> destinations = graph.get(origin);
        while(destinations != null && !destinations.isEmpty()) {
            helper(graph, destinations.poll());
        }
        res.addFirst(origin);
    }
}
