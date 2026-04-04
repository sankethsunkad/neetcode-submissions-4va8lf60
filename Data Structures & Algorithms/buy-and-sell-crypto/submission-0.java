class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int prevVisitedMin = prices[0];
        int max = 0;
        for(int i = 1;i < prices.length;i++) {
            if(prices[i] > prevVisitedMin) {
                max = Math.max(max, prices[i] - prevVisitedMin);
            }
            prevVisitedMin = Math.min(prevVisitedMin, prices[i]);
        }
        return max;
    }
}
