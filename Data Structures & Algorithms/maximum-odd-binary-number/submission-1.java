class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0;i < n;i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
        }
        int check = n - count;

        if(count == 0) return s;

        count--;
        StringBuilder str = new StringBuilder();

        while(count > 0) {
            str.append('1');
            count--;
        }

        while(check > 0) {
            str.append('0');
            check--;
        }
        str.append('1');
        return str.toString();
    }
}