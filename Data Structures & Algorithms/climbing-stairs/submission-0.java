class Solution {
    public int climbStairs(int n) {
        return climbStairs(n , 0);
    }

    public int climbStairs(int n, int step) {
        if(step == n) {
            return 1;
        }
        if(step > n) {
            return 0;
        }
        int left = climbStairs(n, step + 1);
        int right = climbStairs(n, step + 2);
        return left + right;
    }
}
