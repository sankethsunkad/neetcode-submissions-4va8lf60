class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] coins = new int[3];
        for(int bill : bills) {
            int change = bill - 5;
            
            while(change >= 10 && coins[1] > 0) {
                coins[1]--;
                change = change - 10;
            }
            
            while(change >= 5 && coins[0] > 0) {
                coins[0]--;
                change = change - 5;
            }
            
            if(change > 0) return false;
            if(bill == 10) {
                coins[1]++;
            }
            else if(bill == 5){
                coins[0]++;
            }
        }
        return true;
    }
}