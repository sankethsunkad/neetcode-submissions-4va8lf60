class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> q = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));

        for(int num : nums) {
            String text = String.valueOf(num);
            q.offer(text);
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) {
            String curr = q.poll();

            StringBuilder str = new StringBuilder(curr);
            res.append(str);
        }

        return res.toString().charAt(0) == '0' ? "0" : res.toString();
    }
}