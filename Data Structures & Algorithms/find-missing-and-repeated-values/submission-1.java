class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[((int)Math.pow(n , 2) + 1)];

        int a = 0;
        int b = 0;

        for(int[] curr : grid) {
            for(int i = 0;i < curr.length;i++) {
                freq[curr[i]]++;
            }
        }

        for(int i = 1;i <= Math.pow(n , 2);i++) {
            if(freq[i] == 0) {
                a = i;
            }
            else if(freq[i] > 1) {
                b = i;
            }
        }

        return new int[]{b, a};
    }
}