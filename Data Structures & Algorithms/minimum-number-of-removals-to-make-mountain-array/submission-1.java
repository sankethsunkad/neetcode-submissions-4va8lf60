class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] dis = new int[n];

        Arrays.fill(dis, 1);
        Arrays.fill(lis, 1);

        for(int i = 1;i < n;i++) {
            for(int prev = 0;prev < i;prev++) {
                if(nums[i] > nums[prev]) {
                    lis[i] = Math.max(lis[i], 1 + lis[prev]);
                }
            }
        }

        for(int i = n - 2;i >= 0;i--) {
            for(int prev = n - 1;prev > i;prev--) {
                if(nums[i] > nums[prev]) {
                    dis[i] = Math.max(dis[i], 1 + dis[prev]);
                }
            }
        }

        int max = 0;
        for(int i = 0;i < n;i++) {
            if (lis[i] > 1 && dis[i] > 1) {
                max = Math.max(max, lis[i] + dis[i] - 1);
            }
        }
        return n - max;
    }
}
