class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        int[] dest = new int[capacity];

        for(int[] trip : trips) {
            if(!helper(dest, trip)) {
                return false;
            }
        }
        return true;
    }

    boolean helper(int[] dest, int[] trip) {
        int count = 0;
        for(int i = 0;i < dest.length;i++) {
            if(dest[i] <= trip[1]) {
                count++;
                dest[i] = trip[2];
                if(count == trip[0]) {
                    return true;
                }
            }
        }
        return false;
    }
}