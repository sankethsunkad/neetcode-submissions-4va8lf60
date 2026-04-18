class Solution {
    String s;
    public boolean validPalindrome(String s) {
        this.s = s;
        return helper(0, s.length() - 1, false);
    }

    public boolean helper(int i, int j, boolean used) {
        if(i > j) {
            return true;
        }
        if(s.charAt(i) == s.charAt(j)) return helper(i + 1, j - 1, used);

        if(used) return false;
        if(helper(i + 1, j, true)) return true;
        return helper(i ,j - 1, true);
    }
}