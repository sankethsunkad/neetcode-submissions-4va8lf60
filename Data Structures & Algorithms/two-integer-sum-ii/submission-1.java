class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0;i < numbers.length;i++) {
            if(hm.containsKey(target - numbers[i])) {
                res[0] = hm.get(target - numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            hm.put(numbers[i], i);
        }
        return res;
    }
}
