class Solution {
    public String largestGoodInteger(String num) {
        int i = 0;
        int j = 2;
        String res = "";
        while(j < num.length()) {
            String sub = num.substring(i, j + 1);
            if(check(sub)) {
                if (res.isEmpty() || res.charAt(0) < sub.charAt(0)) {
                    res = sub;
                }
            }
            i++;
            j++;
        }
        return res;
    }

    boolean check(String s) {
        char ch = s.charAt(0);
        if(s.charAt(1) == ch && s.charAt(2) == ch) return true;
        return false;
    }
}
