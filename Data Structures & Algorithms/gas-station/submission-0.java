class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int max = 0;
        int n = gas.length;
        for(int i = 0;i < n;i++) {
            if(gas[i] > gas[max]) {
                max = i;
            }
        }

        for(int i = 0;i < n;i++) {
            int curr = (max + i) % n;
            int res = gas[curr];
            boolean check = true;

            for(int j = 0;j < n;j++) {
                int currStep = (curr + j) % n;
                res = res - cost [currStep];
                if(res < 0) {
                    check = false;
                    break;
                }
                res += gas[(currStep + 1) % n];
            }
            if(check) return curr;
        }
        return -1;
    }
}
