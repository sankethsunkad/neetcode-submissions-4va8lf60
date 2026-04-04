class Solution {
    String s1, s2, s3;
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        dp = new int[s1.length() + 1][s2.length() + 1];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return dfs(0, 0);
    }
    boolean dfs(int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        int k = i + j;
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(i + 1, j);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(i, j + 1);
        }
        if(res) dp[i][j] = 1;
        else dp[i][j] = 0;
        return dp[i][j] == 1;
    }
}
