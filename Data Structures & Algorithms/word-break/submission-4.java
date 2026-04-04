class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int max = 0;
        for(String curr : wordDict) {
            max = Math.max(max, curr.length());
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, max, wordDict, dp);
    }
    boolean helper(String s, int index, int max, List<String> wordDict, int[] dp) {
        if(index >= s.length()) return true;
        if(dp[index] != -1) {
            return dp[index] == 1;
        }
        boolean res = false;
        for(int i = index;i < s.length() && (i - index) < max;i++) {
            String str = s.substring(index, i + 1);
            for(String curr : wordDict) {
                if(curr.equals(str) && helper(s, i + 1, max, wordDict, dp)) {
                    res = true;
                    break;
                }
            }
        }
        if(res == true) {
            dp[index] = 1;
        }
        else {
            dp[index] = 0;
        }
        return res;
    }
}
