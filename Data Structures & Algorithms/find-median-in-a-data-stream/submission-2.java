class MedianFinder {
    PriorityQueue<Integer> smallerHalfMaxHeap;
    PriorityQueue<Integer> largerHalfMinHeap;
    public MedianFinder() {
        smallerHalfMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        largerHalfMinHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        smallerHalfMaxHeap.offer(num);
        if (
            smallerHalfMaxHeap.size() - largerHalfMinHeap.size() > 1 ||
            !largerHalfMinHeap.isEmpty() &&
            smallerHalfMaxHeap.peek() > largerHalfMinHeap.peek()
        ) {
            largerHalfMinHeap.add(smallerHalfMaxHeap.poll());
        }
        if (largerHalfMinHeap.size() - smallerHalfMaxHeap.size() > 1) {
            smallerHalfMaxHeap.add(largerHalfMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallerHalfMaxHeap.size() == largerHalfMinHeap.size()) {
            return (double) (largerHalfMinHeap.peek() + smallerHalfMaxHeap.peek()) / 2;
        } else if (smallerHalfMaxHeap.size() > largerHalfMinHeap.size()) {
            return (double) smallerHalfMaxHeap.peek();
        } else {
            return (double) largerHalfMinHeap.peek();
        }
    }
    
}

