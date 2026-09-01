class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();
        int index = 0;
        int abbrIndex = 0;

        while(abbrIndex < m) {
            char ch = abbr.charAt(abbrIndex);
            if(ch >= 'a' && ch <= 'z') {
                if(index >= n || word.charAt(index) != ch) {
                    return false;
                }
                index++;
                abbrIndex++;
            }
            else {
                if(ch == '0') return false;
                int num = 0;
                while(abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = (num * 10) + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                index = index + num;
                if(index > n) return false;
            }
        }
        return true;
    }
}