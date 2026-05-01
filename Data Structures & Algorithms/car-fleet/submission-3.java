class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(position[b], position[a]));
        int n = position.length;
        for(int i = 0;i < n;i++) {
            maxHeap.add(i);
        }
        Stack<Double> stack = new Stack<>();
        int count = 0;
        while(!maxHeap.isEmpty()) {
            int curr = maxHeap.poll();
            double time = (double)(target - position[curr]) / speed[curr];
            System.out.println("Iteration : " + count + " and time is : " + time);
            if(!stack.isEmpty()) {
                if(time > stack.peek()) {
                    stack.push(time);
                }
            }
            else {
                stack.push(time);
            }
            count++;
        }
        return stack.size();
    }
}
