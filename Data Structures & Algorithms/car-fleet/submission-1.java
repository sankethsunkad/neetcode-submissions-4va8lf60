class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0;i < position.length;i++) {
            freqMap.put(position[i], speed[i]);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
        }

        Stack<Double> stack = new Stack<>();

        while(!maxHeap.isEmpty()) {
            Map.Entry<Integer,Integer> entry = maxHeap.poll();
            stack.push((double) (target - entry.getKey()) / entry.getValue());
            if (stack.size() >= 2 && 
                stack.peek() <= stack.get(stack.size() - 2)) 
            {
                stack.pop();
            }
        }
        return stack.size();
    }
}
