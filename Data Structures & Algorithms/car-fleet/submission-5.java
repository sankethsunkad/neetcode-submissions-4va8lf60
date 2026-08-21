class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> position[b] - position[a]);
        for(int i = 0;i < position.length;i++) {
            maxQ.offer(i);
        }

        Stack<Double> stack = new Stack<>();

        while(!maxQ.isEmpty()) {
            int cur = maxQ.poll();
            double time = (double)(target - position[cur]) / speed[cur];

            if(stack.isEmpty()) {
                stack.push(time);
            }
            else {
                if(time > stack.peek()) {
                    stack.push(time);
                }
            }
        }
        return stack.size();
    }
}
