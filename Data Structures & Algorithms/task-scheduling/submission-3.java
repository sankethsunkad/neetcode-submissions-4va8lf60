class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> count[b] - count[a]);

        for(int i = 0;i < 26;i++) {
            if(count[i] > 0) {
                maxQ.offer(i);
            }
        }

        int res = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!maxQ.isEmpty() || !q.isEmpty()) {
            if(!maxQ.isEmpty()) {
                int curr = maxQ.poll();
                count[curr]--;
                if(count[curr] > 0) {
                    q.offer(new int[]{curr, res + n});
                }    
            }
            if(!q.isEmpty() && q.peek()[1] <= res) {
                maxQ.offer(q.poll()[0]);
            }
            res++;
        }

        return res;
    }
}
