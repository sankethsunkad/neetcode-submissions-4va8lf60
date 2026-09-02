class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> ratings[a] - ratings[b]
        );

        for(int i = 0;i < n;i++) {
            queue.offer(i);
        }

        int[]res = new int[n];
        int sum = 0;
        Arrays.fill(res, 1);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int intermittent = 1;
            if((curr - 1) >= 0 && ratings[curr] > ratings[curr - 1]) {
                intermittent = res[curr - 1] + 1;
            }
            if((curr + 1) < n && ratings[curr] > ratings[curr + 1]) {
                intermittent = Math.max(intermittent, res[curr + 1] + 1);
            }
            res[curr] = intermittent;
            sum += intermittent;
        }
        return sum;
    }
}