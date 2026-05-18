class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for (char task : tasks) {
            taskFreq[task - 'A']++;
        }

        PriorityQueue<Integer> maxq = new PriorityQueue<>((a, b) -> taskFreq[b] - taskFreq[a]);
        for(int i = 0;i < 26;i++) {
            if(taskFreq[i] > 0) {
                maxq.offer(i);
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a , b) -> a[1] - b[1]);

        int res = 0;
        while(!maxq.isEmpty() || !q.isEmpty()) {
            if(!maxq.isEmpty()) {
                int curr = maxq.poll();
                taskFreq[curr]--;
                if(taskFreq[curr] > 0) {
                    q.offer(new int[] {curr, res});
                }
                if(!q.isEmpty() && res - q.peek()[1] >= n) {
                    maxq.offer(q.poll()[0]);
                }
            }
            else {
                if(res - q.peek()[1] >= n) {
                    maxq.offer(q.poll()[0]);
                }
            }
            res = res + 1;
        }
        return res;
    }
}
