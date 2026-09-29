class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> count[b] - count[a]);

        Queue<int[]> dummy = new LinkedList<>();

        for(int i = 0;i < 26;i++) {
            if(count[i] > 0) {
                maxQ.offer(i);
            }
        }

        int res = 0;

        while(!maxQ.isEmpty() || !dummy.isEmpty()) {
            if(!maxQ.isEmpty()) {
                int curr = maxQ.poll();
                count[curr]--;
                if(count[curr] > 0) {
                    dummy.offer(new int[]{curr, res + n + 1});
                }
            }
            res++;
            if(!dummy.isEmpty() && dummy.peek()[1] <= res) {
                maxQ.offer(dummy.poll()[0]);
            }
            
        }
        return res;
    }
}