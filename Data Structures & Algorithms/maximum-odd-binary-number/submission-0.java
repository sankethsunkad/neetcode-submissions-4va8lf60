class Solution {
    public String maximumOddBinaryNumber(String s) {
        int[] count = new int[2];

        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '0') {
                count[0]++;
            }
            else {
                count[1]++;
            }
        }

        StringBuilder str = new StringBuilder();

        for(int i = 0;i < count[1] - 1;i++) {
            str.append('1');
        }
        
        for(int i = 0;i < count[0];i++) {
            str.append('0');
        }

        str.append('1');
        return str.toString();
    }
}