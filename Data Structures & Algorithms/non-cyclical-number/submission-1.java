class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int slow = helper(n);
        int fast = helper(slow);
        if(fast == 1 || slow == 1) return true;
        while(slow != fast) {
            slow = helper(slow);
            fast = helper(helper(fast));
            if(fast == 1 || slow == 1) return true;
        }
        return false;
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