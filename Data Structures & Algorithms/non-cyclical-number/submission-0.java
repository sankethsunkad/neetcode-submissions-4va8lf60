class Solution {
    HashSet<Integer> seen = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(seen.contains(n)) return false;

        seen.add(n);

        int sum = 0;
        while(n > 0) {
            int co = n % 10;
            sum = sum + (co * co);
            n = n / 10;
        }
        
        return isHappy(sum);
    }
}