class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        return helper(s, t, 0, 0, dp);
    }

    int helper(String s, String t, int sIndex, int tIndex, int[][] dp) {
        if(tIndex == t.length()) return 1;
        if(sIndex == s.length()) return 0;

        if(dp[sIndex][tIndex] != -1) {
            return dp[sIndex][tIndex];
        }

        int res = 0;
        if(s.charAt(sIndex) == t.charAt(tIndex)) {
            res += helper(s, t, sIndex + 1, tIndex + 1, dp);
        }

        res += helper(s, t, sIndex + 1, tIndex, dp);
        dp[sIndex][tIndex] = res;
        return res;
    }
}
