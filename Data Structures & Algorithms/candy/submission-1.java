class Solution {
    public int candy(int[] ratings) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> ratings[a] - ratings[b]);
        int n = ratings.length;
        for(int i = 0;i < n;i++) {
            minQ.offer(i);
        }

        int[] res = new int[n];

        int sum = 0;
        while(!minQ.isEmpty()) {
            int curr = minQ.poll();
            int left = curr - 1;
            int temp = 1;
            if(left >= 0 && ratings[curr] > ratings[left]) {
                temp = Math.max(temp, res[left] + 1);
            }
            int right = curr + 1;
            if(right < n && ratings[curr] > ratings[right]) {
                temp = Math.max(temp, res[right] + 1);
            }
            sum += temp;
            res[curr] = temp;
        }
        return sum;
    }
}