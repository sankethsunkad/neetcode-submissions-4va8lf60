class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char c = s.charAt(i);
            char d = s.charAt(j);
            if(isValid(c) && isValid(d)) {
                if (Character.toLowerCase(c) != Character.toLowerCase(d)) {
                    return false;
                }
                i++;
                j--;
            }
            else {
                if(!isValid(c)) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }
        return true;
    }

    boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
