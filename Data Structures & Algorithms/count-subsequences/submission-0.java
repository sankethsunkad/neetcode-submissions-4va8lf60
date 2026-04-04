class Solution {
    String s;
    String t;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        return helper(0, 0);
    }

    int helper(int i, int j) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        int res = helper(i + 1, j);


        if(s.charAt(i) == t.charAt(j)) {
            res = res + helper(i + 1, j + 1);
        }
        return res;
    }
}
