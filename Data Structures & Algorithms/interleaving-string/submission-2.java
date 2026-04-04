class Solution {
    String s1, s2, s3;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        return dfs(0, 0);
    }

    boolean dfs(int i, int j) {
        // Base case: fully consumed s1 and s2
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        int k = i + j;
        boolean res = false;

        // Take from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(i + 1, j);
        }

        // Take from s2 (only if needed)
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(i, j + 1);
        }

        return res;
    }
}
