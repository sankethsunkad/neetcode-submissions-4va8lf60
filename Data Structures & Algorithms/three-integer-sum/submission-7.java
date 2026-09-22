class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {   
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0;i < nums.length - 2;i++) {
            map.put(nums[i], map.get(nums[i]) - 1);
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for(int j = i + 1;j < nums.length - 1;j++) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

               
                int req = 0 - (nums[i] + nums[j]);

                if(map.containsKey(req) && map.get(req) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], req));
                }
            }

            for(int j = i + 1;j < nums.length;j++) {
                map.put(nums[j], map.get(nums[j]) + 1);
            }
        }
        return res;
    }
}