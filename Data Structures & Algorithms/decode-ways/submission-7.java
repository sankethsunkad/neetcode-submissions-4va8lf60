class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        dp[0] = helper(0, s, dp);
        return dp[0];
    }   

    int helper(int i, String s, int[] dp) {
        if(i == s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        if(s.charAt(i) == '0') return 0;
        int res = helper(i + 1, s, dp);
        if((s.charAt(i) == '1') && (i + 1 < s.length()) || ((s.charAt(i) == '2') && (i + 1) < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6')) {
            res += helper(i + 2, s, dp);
        }
        dp[i] = res;
        return dp[i];
    }
}
