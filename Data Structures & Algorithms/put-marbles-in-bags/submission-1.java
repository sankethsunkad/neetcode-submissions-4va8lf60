class Solution {
    public long putMarbles(int[] weights, int k) {
        if (k == 1 || k == weights.length) {
            return 0;
        }

        PriorityQueue<Integer> minQ = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                weights[a] + weights[a + 1],
                weights[b] + weights[b + 1]
            )
        );

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                weights[b] + weights[b + 1],
                weights[a] + weights[a + 1]
            )
        );

        for (int i = 0; i < weights.length - 1; i++) {
            minQ.offer(i);
            maxQ.offer(i);
        }

        long res = 0;

        while (k > 1) {
            int maxIndex = maxQ.poll();
            int minIndex = minQ.poll();

            res += (long) weights[maxIndex] + weights[maxIndex + 1]
                 - ((long) weights[minIndex] + weights[minIndex + 1]);

            k--;
        }

        return res;
    }
}
