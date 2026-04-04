class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, 0, false);
    }

    int helper(int[] prices, int index, int sum, boolean bought) {
        if(index >= prices.length) return 0;
        int res = 0;
        if(bought) {
            for(int i = index;i < prices.length;i++) {
                res = Math.max(res, (prices[i] - sum) + helper(prices, i + 2, 0, false));
            }
        }
        else {
            res = Math.max(helper(prices, index + 1, 0, false), helper(prices, index + 1, prices[index], true));
        }
        return res;
    }
}
