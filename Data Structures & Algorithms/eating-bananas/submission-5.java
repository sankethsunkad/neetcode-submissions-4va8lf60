class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int time = helper(piles, mid);
            if(time > h) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }

    int helper(int[] piles, int n) {
        int res = 0;
        for(int pile : piles) {
            if(pile % n == 0) {
                res = res + (pile / n);
            }
            else {
                res = res + (pile / n);
                res = res + 1;
            }
        }
        return res;
    }
}
