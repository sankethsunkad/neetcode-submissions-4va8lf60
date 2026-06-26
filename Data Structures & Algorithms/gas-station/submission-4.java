class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int curr = 0;

        for(int i = 0;i < gas.length;i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if(tank < 0) {
                tank = 0;
                curr = i + 1;
            }
        }
        if(total >= 0) {
            return curr;
        }
        return -1;
    }
}
