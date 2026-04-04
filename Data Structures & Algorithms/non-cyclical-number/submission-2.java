class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int slow = helper(n);
        int fast = helper(slow);
        while(slow != fast) {
            slow = helper(slow);
            fast = helper(helper(fast));
        }
        return fast == 1;
    }

    int helper(int n) {
        int sum = 0;
        while(n > 0) {
            int co = n % 10;
            sum = sum + (co * co);
            n = n / 10;
        }
        return sum;
    }
}