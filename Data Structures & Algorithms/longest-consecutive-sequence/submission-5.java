class Solution {
    HashSet<Integer> seen;
    public int longestConsecutive(int[] nums) {
        seen = new HashSet<>();
        int max = 0;
        for(int num : nums) {
            seen.add(num);
            max = Math.max(max, 1 + helperLeft(num - 1) + helperRight(num + 1));
        }
        return max;
    }

    public int helperLeft(int num) {
        if(seen.contains(num)) {
            return 1 + helperLeft(num - 1);
        }
        return 0;
    }

    public int helperRight(int num) {
        if(seen.contains(num)) {
            return 1 + helperRight(num + 1);
        }
        return 0;
    }
}
