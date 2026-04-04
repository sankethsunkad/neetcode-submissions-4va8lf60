class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int start = 0;
        int end = heights.length - 1;
        while(start < end) {
            int area = (end - start) * Math.min(heights[start], heights[end]);
            maxArea = Math.max(maxArea, area);
            if(heights[start] < heights[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        return maxArea;
    }
}
