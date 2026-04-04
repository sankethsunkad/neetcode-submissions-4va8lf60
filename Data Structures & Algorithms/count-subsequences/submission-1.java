class Solution {
    String s;
    String t;
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m > n) return 0;
        dp = new int[n][m];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        this.s = s;
        this.t = t;
        return helper(0, 0);
    }

    int helper(int i, int j) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        int res = helper(i + 1, j);

        if(s.charAt(i) == t.charAt(j)) {
            res = res + helper(i + 1, j + 1);
        }
        dp[i][j] = res;
        return dp[i][j];
    }
}
