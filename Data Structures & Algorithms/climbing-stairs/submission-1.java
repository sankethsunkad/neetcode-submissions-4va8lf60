class Solution {
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, -1));
        return climbStairs(n , 0, dp);
    }

    public int climbStairs(int n, int step, List<Integer> dp) {
        if(step == n) {
            return 1;
        }
        if(step > n) {
            return 0;
        }
        if(dp.get(step) != -1) {
            return dp.get(step);
        }
        int left = climbStairs(n, step + 1, dp);
        int right = climbStairs(n, step + 2, dp);
        dp.set(step, left + right);
        return left + right;
    }
}
