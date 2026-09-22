class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
            }
            else {
                set.add(num);
            }
        }

        int[] res = new int[2];
        int index = 0;
        for(int num : set) {
            res[index++] = num;
        }
        return res;
    }
}