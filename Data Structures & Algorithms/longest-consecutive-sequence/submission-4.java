class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < nums.length;i++) {
            hs.add(nums[i]);
        }

        int longest = 1;
        int current = 1;

        for(int num : hs) {
            if(!hs.contains(num - 1)) {
                current = 1;
                while(hs.contains(num + 1)) {
                    current++;
                    longest = Math.max(longest, current);
                    num = num + 1;
                }
            }
        }
        return longest;
    }
}
