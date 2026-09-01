class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // HashSet<List<Integer>> set = new HashSet<>();
        // for(int i = 0;i < nums.length - 3;i++) {
        //     for(int j = i + 1;j < nums.length - 2;j++) {
        //         for(int k = j + 1;k < nums.length - 1;k++) {
        //             for(int l = k + 1;l < nums.length;l++) {
        //                 long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

        //                 if (sum == target) {
        //                     List<Integer> temp = new ArrayList<>();
        //                     temp.add(nums[i]);
        //                     temp.add(nums[j]);
        //                     temp.add(nums[k]);
        //                     temp.add(nums[l]);
        //                     Collections.sort(temp);
        //                     if(!set.contains(temp)) {
        //                         res.add(temp);
        //                         set.add(temp);
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }

        Arrays.sort(nums);

        for(int i = 0;i < nums.length - 3;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1;j < nums.length - 2;j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long sum =(long) nums[i] + nums[j];
                long required = (long) target - sum;
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high) {
                    long interSum = (long)nums[low] + nums[high];
                    if(interSum == required) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        res.add(temp);
                        low++;
                        high--;
                        while(low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                        while(low < high && nums[high] == nums[high + 1]) {
                            high--;
                        }
                    }
                    else if(interSum < required) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}