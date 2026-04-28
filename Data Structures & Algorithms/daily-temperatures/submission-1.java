class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < n) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else if(temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            }
            else {
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int val = stack.pop();
                    res[val] = i - val;
                }
                stack.push(i);
            }
            i++;
        }
        return res;
    }
}
