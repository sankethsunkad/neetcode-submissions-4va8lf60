class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int m = queries.length;
        int[] res = new int[m];
        for(int i = 0;i < m;i++) {
            int q = queries[i];
            int min = Integer.MAX_VALUE;
            for(int[] curr : intervals) {
                if(q>= curr[0] && q <= curr[1]) {
                    min = Math.min(min, curr[1] - curr[0] + 1);
                }
            }
            if(min != Integer.MAX_VALUE) {
                res[i] = min;
            }
            else {
                res[i] = -1;
            }
        }
        return res;
    }
}
