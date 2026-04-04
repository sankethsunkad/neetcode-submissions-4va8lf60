class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < piles.length;i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        while(min < max) {
            int mid = min + (max - min) / 2;
            int hours = hoursNeeded(piles, mid);
            if(hours > h) {
                min = mid + 1;
            }
            else { 
                max = mid;
            }
        }
        return min;
    }

    int hoursNeeded(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil(pile / (double) k);
        }
        return hours;
    }
}
