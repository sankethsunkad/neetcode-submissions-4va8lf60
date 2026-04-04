class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] road = new int[1001];

        for(int[] trip : trips) {
            road[trip[1]] += trip[0]; 
            road[trip[2]] -= trip[0]; 
        }

        int passengers = 0;

        for(int i = 0; i < 1001; i++) {
            passengers += road[i];
            if(passengers > capacity) {
                return false;
            }
        }

        return true;
    }
}