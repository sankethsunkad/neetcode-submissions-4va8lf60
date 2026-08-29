class Solution {
    public int maxArea(int[] heights) {
        int low = 0;
        int high = heights.length - 1;

        int res = 0;
        while(low < high) {
            res = Math.max(res, Math.min(heights[low], heights[high]) * (high - low));
            if(heights[low] < heights[high]) {
                low++;
            }
            else {
                high--;
            }
        }

        return res;
    }
}
