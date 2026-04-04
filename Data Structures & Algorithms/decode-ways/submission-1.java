class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return helper(s, 0);
    }

    int helper(String s, int index) {
        if(index >= s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        int res = 0;
        if(s.charAt(index) == '1') {
            if(index + 1 == s.length()) return 1;
            res = res + helper(s, index + 2);
        }
        else if(s.charAt(index) == '2' && (index + 1) < s.length() && s.charAt(index + 1) != '7' && s.charAt(index + 1) != '8' && s.charAt(index + 1) != '9') {
            res = res + helper(s, index + 2);
        }
        res = res + helper(s, index + 1);
        return res;
    }
}
