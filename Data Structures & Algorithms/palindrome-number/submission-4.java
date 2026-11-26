class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        long div = 1;
        while(div * 10 <= x) {
            div = div * 10;
        }

        while(x != 0) {
            if(x % 10 != x / div) return false;

            x = x % (int)div;
            x = (int)x / 10;

            div = div / 100;
        }

        return true;
    }
}