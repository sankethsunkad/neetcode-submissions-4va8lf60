class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int pile : piles) {
            r = Math.max(r, pile);
        }

        while(l <= r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for(int pile : piles) {
                hours = hours + (int)Math.ceil((double)pile / mid);
            }
            System.out.println("value of hours when l = " + l + " and when r is = " + r + " then hours = " + hours);

            if(hours > h) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }
}
