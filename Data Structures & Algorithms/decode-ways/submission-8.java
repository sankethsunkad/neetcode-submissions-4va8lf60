class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1;i >= 0;i--) {
            char ch = s.charAt(i);
            if(ch == '0'){
                dp[i] = 0;
            }
            else {
                dp[i] = dp[i + 1];
                if((i + 1 < n) && (ch == '1' || (ch == '2' && s.charAt(i + 1) < '7'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }
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
