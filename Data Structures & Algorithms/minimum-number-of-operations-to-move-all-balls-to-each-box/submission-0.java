class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] count = new int[n];

        for(int i = 0;i < boxes.length();i++) {
            if(boxes.charAt(i) - '0' > 0) {
                count[i]++;
            }
        }

        int[] res = new int[n];
        int left = 0;
        int right = 0;
        int leftCount = 0;
        int rightCount = 0;
        for(int i = 0;i < n;i++) {
            if(count[i] == 1) {
                rightCount++;
                right += i;
            }
        }
        
        for(int i = 0;i < n;i++) {
            res[i] = left + right;
            if(count[i] == 1) {
                leftCount++;
                rightCount--;
            }
            left = left + leftCount;
            right = right - rightCount;
        }
        return res;
    }
}