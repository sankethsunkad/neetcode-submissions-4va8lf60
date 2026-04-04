class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }

    int helper(String s, int index, int[] dp) {
        if(index >= s.length()) return 1;
        if(dp[index] != -1) return dp[index];
        if(s.charAt(index) == '0'){
            dp[index] = 0;
            return dp[index];
        } 
        int res = 0;
        res = res + helper(s, index + 1, dp);
        if(s.charAt(index) == '1') {
            if(index + 1 == s.length()) return 1;
            res = res + helper(s, index + 2, dp);
        }
        else if(s.charAt(index) == '2' && (index + 1) < s.length() && s.charAt(index + 1) != '7' && s.charAt(index + 1) != '8' && s.charAt(index + 1) != '9') {
            res = res + helper(s, index + 2, dp);
        }
        dp[index] = res;
        return dp[index];
    }
}
