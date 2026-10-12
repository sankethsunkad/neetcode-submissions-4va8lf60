class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        for(int i = heights.length - 1;i >= 0;i--) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else if(heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
        }

        int n = stack.size();
        int[] res = new int[n];

        int index = 0;
        while(index < n) {
            res[index] = stack.pop();
            index++;
        }
        return res;
    }
}