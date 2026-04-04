class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> freq[b] - freq[a]);
        
        for (int i = 0;i < 26;i++) {
            if(freq[i] > 0) maxHeap.offer(i);
        }

        Queue<int[]> queue = new LinkedList<>();

        int res = 0;
        while(!queue.isEmpty() || !maxHeap.isEmpty()) {
            res++;
            if(!maxHeap.isEmpty()) {
                int f = maxHeap.poll();
                freq[f]--;
                if(freq[f] > 0) {
                    queue.offer(new int[]{res + n ,f});
                }
            }
            if(!queue.isEmpty()) {
                if(queue.peek()[0] == res) {
                    maxHeap.offer(queue.poll()[1]);
                }
            }
        }
        return res;
    }
}
