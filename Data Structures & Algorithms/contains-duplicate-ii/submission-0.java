class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            if(hashSet.contains(nums[i]) && (i - hm.get(nums[i]) <= k)) {
                return true;
            }
            hashSet.add(nums[i]);
            hm.put(nums[i], i);
        }
        return false;
    }
}