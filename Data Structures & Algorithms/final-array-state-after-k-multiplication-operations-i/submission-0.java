class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> {
    int cmp = Integer.compare(nums[a], nums[b]);
    return cmp != 0 ? cmp : Integer.compare(a, b);
});
        for(int i = 0;i < nums.length;i++) {
            minQ.offer(i);
        }

        while(k > 0) {
            int curr = minQ.poll();
            nums[curr] = nums[curr] * multiplier;
            minQ.offer(curr);
            k--;
        } 

        return nums;
    }
}