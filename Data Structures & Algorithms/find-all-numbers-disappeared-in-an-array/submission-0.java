class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] check = new int[nums.length + 1];

        for(int num : nums) {
            check[num]++;
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 1;i <= nums.length;i++) {
            if(check[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}