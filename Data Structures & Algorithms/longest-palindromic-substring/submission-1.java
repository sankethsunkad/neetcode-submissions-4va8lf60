class Solution {
    
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        String res = s.substring(0, 1);

        int n = s.length();
        for(int i = 0;i < n - 1;i++) {
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > res.length()) {
                    res = s.substring(left, right + 1);    
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > res.length()) {
                    res = s.substring(left, right + 1);    
                }
                left--;
                right++;
            }
        }
        return res;    
    }
}
