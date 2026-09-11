class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;  
        return helper(prices, 0, true, 0);  
    }

    int helper(int[] prices, int index, boolean canBuy, int currBoughtPrice) {
        if(index == prices.length) return 0;
        int res = 0;
        if(canBuy) {
            res = Math.max(res, helper(prices, index + 1, false, prices[index]));
            res = Math.max(res, helper(prices, index + 1, true, currBoughtPrice));
        }

        else {
            res = Math.max(res, prices[index] - currBoughtPrice);
            res = Math.max(res, helper(prices, index + 1, canBuy, currBoughtPrice));
        }
        return res;
    }
}
