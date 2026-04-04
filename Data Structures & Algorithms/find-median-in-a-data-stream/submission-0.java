class MedianFinder {
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minHeap.add(num);
    }
    
    public double findMedian() {
        int n = minHeap.size();
        Queue<Integer> temp = new LinkedList<>();
        int counter = 0;
        double res = 0;
        if(!minHeap.isEmpty() && n % 2 == 0) {
            while(counter < (n / 2 - 1)) {
                temp.offer(minHeap.poll());                    
                counter++;
            }
            int pre = minHeap.poll();
            int post = minHeap.poll();
            res = (pre + post) / 2.0;
            minHeap.offer(pre);
            minHeap.offer(post);
        }
        else if(!minHeap.isEmpty()){
            while(counter < (n / 2)) {
                temp.offer(minHeap.poll());
                counter++;
            }
            int pre = minHeap.poll();
            res = pre;
            minHeap.offer(pre);
        }
        while(!temp.isEmpty()) {
            minHeap.offer(temp.poll());
        }
        return res;
    }
}

