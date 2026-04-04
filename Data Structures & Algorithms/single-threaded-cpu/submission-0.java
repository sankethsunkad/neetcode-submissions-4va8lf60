class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = new int[tasks.length];
        int i = 0;
        for(int[] task : tasks) {
            queue.offer(new int[]{task[0], task[1], i++});
        }

        PriorityQueue<int[]> active = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int time = 0;
        i = 0;
        while(!queue.isEmpty() || !active.isEmpty()) {
            while(!queue.isEmpty() && queue.peek()[0] <= time) {
                int[] task = queue.poll();
                active.offer(new int[]{task[1], task[2]});
            }

            if(active.isEmpty()) {
                time = queue.peek()[0];
                continue;
            }

            int[] task = active.poll();
            res[i++] = task[1];
            time = time + task[0];
        }
        return res;
    }
}