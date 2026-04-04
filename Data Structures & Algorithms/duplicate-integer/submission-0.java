class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // Corrected the instantiation of HashMap
        for (int num : nums) {
            if (hm.containsKey(num)) { // Check if the number already exists in the map
                return true; // Duplicate found
            } else {
                hm.put(num, 1); // Store the number in the map
            }
        }
        return false; // No duplicates found
    }
}
