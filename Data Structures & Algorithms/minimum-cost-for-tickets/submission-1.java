class Solution {
    int[] duration = new int[]{1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(days, costs, 0, dp);
    }

    int helper(int[] days, int[] costs, int index, int[] dp) {
        if(index == days.length) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0;i < costs.length;i++) {
            int day = index;

            int max = days[index] + duration[i];

            while(day < days.length && days[day] < max) {
                day++;
            }

            res = Math.min(res, costs[i] + helper(days, costs, day, dp));
        }
        dp[index] = res;
        return res;
    }
}