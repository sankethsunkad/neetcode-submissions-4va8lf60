class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int n = s.length();
        String res = s.substring(0, 1);
        int maxLen = 1;

        for(int i = 0;i < n;i++) {
            int left = i, right = i;
            while(left >=0 && right < n && s.charAt(left) == s.charAt(right)) {
                int length = right - left + 1;
                if(length > maxLen) {
                    res = s.substring(left, right + 1);
                    maxLen = length;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while(left >=0 && right < n && s.charAt(left) == s.charAt(right)) {
                int length = right - left + 1;;
                if(length > maxLen) {
                    res = s.substring(left, right + 1);
                    maxLen = length;
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
