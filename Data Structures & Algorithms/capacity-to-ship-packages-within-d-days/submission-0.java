class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for(int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        int low = max;
        int high = sum;
        int count = 0;
        while(low < high) {
            int mid = low + (high - low) / 2;
            count = 1;
            int curr = 0;
            for(int weight : weights) {
                if(curr + weight > mid) {
                    count++;
                    curr = 0;
                }
                curr = curr + weight;
                
            }
            if(count > days) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}