class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];
        // for(int[] curr : dp) {
        //     Arrays.fill(curr, -1);
        // }
        // return helper(text1, 0, text2, 0, dp);

        for(int i = text1.length() - 1;i >= 0;i--) {
            int[] curr = new int[text2.length() + 1];
            for(int j = text2.length() - 1;j >=0;j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + prev[j + 1];
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j + 1]);
                }
            }
            prev = curr;
        }
        return prev[0];
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
