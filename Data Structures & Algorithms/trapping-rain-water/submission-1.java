class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1, right = height.length - 2;
        int area = 0;
        while(left <= right) {
            if(rightMax < leftMax) {
                int sum = Math.min(rightMax, leftMax) - height[right];
                if(sum > 0) {
                    area = area + sum;
                }
                rightMax = Math.max(height[right], rightMax);
                right--;
            }
            else {
                int sum = Math.min(rightMax, leftMax) - height[left];
                if(sum > 0) {
                    area = area + sum;
                }
                leftMax = Math.max(height[left], leftMax);
                left++;
            }
        }
        return area;
    }
}
