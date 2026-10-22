class Solution {
    int[][] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1][s.length() + 1];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }
        HashSet<String> hashset = new HashSet<>();
        for(String curr : wordDict) {
            hashset.add(curr);
        }
        return helper(s, 0, 0, hashset);
    }

    boolean helper(String s, int i, int j, HashSet<String> hashset) {
        if(i == s.length()) return true;
        if(j == s.length() - 1) {
            if(hashset.contains(s.substring(i, j + 1))) return true;
            return false;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean res = helper(s, i, j + 1, hashset);

        if(hashset.contains(s.substring(i, j + 1))) {
            res = res || helper(s, j + 1, j + 1, hashset);
        }
        if(res) {
            dp[i][j] = 1;
        }
        else {
            dp[i][j] = 0;
        }
        return res;
    }
}
