class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2;

        long goodPairs = 0;
        HashMap<Integer, Long> diffMap = new HashMap<>();

        for(int i = 0;i < n;i++) {
            int diff = nums[i] - i;
            long count = diffMap.getOrDefault(diff, 0L);
            goodPairs += count;
            diffMap.put(diff, count + 1);
        }
        return totalPairs - goodPairs;
    }
}
