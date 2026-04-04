class Solution {
    public int countSubstrings(String s) {
        //return helper(s, 0);
        int n = s.length();
        int[][] dp = new int[n][n];

        int res = 0;

        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= i;j++) {
                if(s.charAt(i) == s.charAt(j) && ((i - j) <= 2 || dp[i - 1][j + 1] == 1)) {
                    res++;
                    dp[i][j] = 1;
                }
            }
        }
        return res;
    }

    int helper(String s, int index) {
        if(index == s.length()) return 0;
        int res = 0;
        for(int i = index;i < s.length();i++) {
            String str = s.substring(index, i + 1);
            if(isValid(str)) {
                res++;
            }
        }
        return res + helper(s, index + 1);
    }

    boolean isValid(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i < str.length() && j >=0 && i < j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
