class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> gas[b] - gas[a]);
        for(int i = 0;i < gas.length;i++) {    
            maxQ.offer(i);
        }

        while(!maxQ.isEmpty()) {
            int curr = maxQ.poll();
            if(helper(gas, cost, curr)) {
                return curr;
            }
        }
        return -1;
    }

    boolean helper(int[] gas, int[] cost, int index) {
        int currGas = 0;
        for(int i = 0;i < gas.length;i++) {
            int currIndex = (index + i) % gas.length;
            currGas += gas[currIndex];
            if(cost[currIndex] > currGas) {
                return false;
            }
            currGas -= cost[currIndex];
        }
        if(currGas < 0) return false;
        return true;
    }
}
