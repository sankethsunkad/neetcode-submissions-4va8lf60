class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0;i < n;i++) {
            if(i + 1 == n) {
                right[i] = 0;
            }
            else {
                int max = right[i];
                int j = i;
                while(j < n) {
                    max = Math.max(max, height[j]);
                    j++;
                }
                if(height[i] == max) {
                    right[i] = 0;
                }
                else {
                    right[i] = max;
                }
            }
        }

        for(int i = 0;i < n;i++) {
            if(i - 1 < 0) {
                left[i] = 0;
            }
            else {
                int max = left[i];
                int j = i;
                while(j >= 0) {
                    max = Math.max(max, height[j]);
                    j--;
                }
                if(height[i] == max) {
                    left[i] = 0;
                }
                else {
                    left[i] = max;
                }
            }
        }

        int res = 0;

        for(int i = 0;i < n;i++) {
            if(right[i] != 0 && left[i] != 0) {
                res = res + Math.min(left[i], right[i]) - height[i];
            }
        }
        return res;
    }
}
