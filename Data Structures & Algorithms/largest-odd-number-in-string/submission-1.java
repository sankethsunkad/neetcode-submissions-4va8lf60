class Solution {
    public String largestOddNumber(String num) {
        String res = "";
        int n = num.length() - 1;
        for(int i = n;i >= 0;i--) {
            int check = num.charAt(i) - '0';
            if(check % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return res;
    }
}
