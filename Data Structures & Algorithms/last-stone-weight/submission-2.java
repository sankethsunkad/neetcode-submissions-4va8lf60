class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0;i < stones.length;i++) {
            maxHeap.offer(stones[i]);
        }

        while(maxHeap.size() != 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if(a == b) {
                if(maxHeap.size() == 0) {
                    return 0;
                }
            }
            a = a - b;
            maxHeap.offer(a);
        }
        return maxHeap.peek();
    }
}
