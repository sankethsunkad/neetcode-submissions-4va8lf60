class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = n - 1;
        while(l < n && r >= 0) {
            left[l] = leftMax;
            right[r] = rightMax;
            if(height[l] > leftMax) {
                leftMax = height[l];
            }
            if(height[r] > rightMax) {
                rightMax = height[r];
            }
            l++;
            r--;
        }

        int res = 0;

        for(int i = 0;i < n;i++) {
            int sum = Math.min(left[i], right[i]) - height[i];
            if(sum > 0) {
                res = res + sum;
            }
        }
        return res;
    }
}
