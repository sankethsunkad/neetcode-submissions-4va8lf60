class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int leftMin = height[0];
        for(int i = 1;i < n;i++) {
            left[i] = leftMin;
            leftMin = Math.max(leftMin, height[i]);
        }

        int rightMin = height[n - 1];
        for(int i = n - 2;i >= 0;i--) {
            right[i] = rightMin;
            rightMin = Math.max(rightMin, height[i]);
        }

        int res = 0;
        for(int i = 1;i < n - 1;i++) {
            int temp = Math.min(left[i], right[i]) - height[i];
            if(temp > 0) {
                res += temp;
            }
        }

        return res;
    }
}
