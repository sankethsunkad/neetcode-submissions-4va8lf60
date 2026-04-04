class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(text1, 0, text2, 0, dp);
    }
    int helper(String text1, int i, String text2, int j, int[][] dp) {
        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + helper(text1, i + 1, text2, j + 1, dp);
        }
        else {
            dp[i][j] = Math.max(helper(text1, i + 1, text2, j, dp), helper(text1, i, text2, j + 1, dp));
        }
        return dp[i][j];
    }
}
