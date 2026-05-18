class MedianFinder {
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;
    public MedianFinder() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        maxQ.add(num);
        balanceHeap();
    }
    
    public double findMedian() {
        if(minQ.size() == maxQ.size()) {
            if(!minQ.isEmpty()) {
                return ((double) minQ.peek() + maxQ.peek()) / 2;
            }
            if(maxQ.isEmpty()) {
                return -1;
            }
            return (double)minQ.peek();
        }
        else {
            if(minQ.size() > maxQ.size()) {
                return (double)minQ.peek();
            }
            return (double)maxQ.peek();
        }
    }

    public void balanceHeap() {
        if(!minQ.isEmpty()) {
            while(maxQ.peek() > minQ.peek()) {
                minQ.offer(maxQ.poll());
            }
        }
        while(Math.abs(minQ.size() - maxQ.size()) > 1) {
            if(minQ.size() > maxQ.size()) {
                maxQ.offer(minQ.poll());
            }
            else {
                minQ.offer(maxQ.poll());
            }
        }
    }
}
