class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        for(int i = 0;i < n;i++) {
            for(int j = i;j < n;j++) {
                int min = findMin(heights, i, j);
                res = Math.max(res, (j - i + 1) * min);
            }
        }
        return res;
    }

    public int findMin(int[] heights, int m, int n) {
        int res = Integer.MAX_VALUE;
        for(int i = m;i <= n;i++) {
            res = Math.min(res, heights[i]);
        }
        return res;
    }
}
