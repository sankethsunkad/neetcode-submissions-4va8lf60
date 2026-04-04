class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int start = 0;
        int end = height.length - 1;
        int left = -1;
        int right = -1;
        while(start < height.length && end >= 0) {
            leftMax[start] = left;
            if(height[start] > left) {
                left = height[start];
            }
            rightMax[end] = right;
            if(height[end] > right) {
                right = height[end];
            }
            start++;
            end--;
        }
        int area = 0;
        for(int i = 0;i < height.length;i++) {
            int sum = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(sum > 0) {
                area +=sum;
            }
        }
        return area;
    }
}
